package com.weightwatchers.ww_exercise_01.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.weightwatchers.ww_exercise_01.model.FoodDatabase
import com.weightwatchers.ww_exercise_01.model.FoodModel
import com.weightwatchers.ww_exercise_01.networking.FoodsApiService
import com.weightwatchers.ww_exercise_01.util.SharedPreferenceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : BaseViewModel(application) {

    private var prefHelper = SharedPreferenceHelper(getApplication())

    private var refreshTime = 5 * 60 * 1000 * 1000 * 1000L

    private val foodsApiService = FoodsApiService()

    private val disposable = CompositeDisposable()

    val foods = MutableLiveData<List<FoodModel>>()

    val foodsLoaderError = MutableLiveData<Boolean>()

    val loading = MutableLiveData<Boolean>()


    fun refresh() {
        val updateTime: Long? = prefHelper.getUpdateTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            fetchFromDatabase()
        } else {
            fetchFromRemote()
        }
    }


    fun refreshBypassCache() {
        fetchFromRemote()
    }

    private fun fetchFromDatabase() {
        loading.value = true
        launch {
            val food = FoodDatabase(getApplication()).foodDao().getAllFoods()
            foodsRetrieved(food)
            Log.d("ListViewModel", "Food retrieved from Database")
        }
    }


    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
                foodsApiService.getFoods()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<List<FoodModel>>() {

                            override fun onSuccess(foodList: List<FoodModel>) {
                                storeFoodLocally(foodList)

                                Log.d("ListViewModel", "onSuccess")

                            }

                            override fun onError(e: Throwable) {
                                foodsLoaderError.value = true
                                loading.value = false
                                e.printStackTrace()
                                Log.d("ListViewModel", "onError")

                            }


                        })
        )
    }


    private fun storeFoodLocally(list: List<FoodModel>) {
        launch {
            val dao = FoodDatabase(getApplication()).foodDao()
            dao.deleteAllFoods()
            val result = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = result[i].toInt()
                ++i
            }
            foodsRetrieved(list)

        }

        prefHelper.savedUpdateTime(System.nanoTime())

    }


    private fun foodsRetrieved(foodList: List<FoodModel>) {
        foods.value = foodList
        foodsLoaderError.value = false
        loading.value = false
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}