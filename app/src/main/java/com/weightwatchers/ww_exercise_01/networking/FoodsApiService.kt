package com.weightwatchers.ww_exercise_01.networking

import com.weightwatchers.ww_exercise_01.model.FoodModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FoodsApiService {

    private val Base_Url = "https://www.weightwatchers.com/"

    private val apiService = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FoodApi::class.java)

    fun getFoods(): Single<List<FoodModel>> {
        return apiService.getFoods()
    }
}