package com.weightwatchers.ww_exercise_01.networking

import com.weightwatchers.ww_exercise_01.model.FoodModel
import io.reactivex.Single
import retrofit2.http.GET

interface FoodApi {

    @GET("assets/cmx/us/messages/collections.json")
    fun getFoods():Single<List<FoodModel>>
}