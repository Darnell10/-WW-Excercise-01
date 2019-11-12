package com.weightwatchers.ww_exercise_01.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert
    suspend fun insertAll(vararg foods: FoodModel): List<Long>


    @Query("SELECT * FROM foodmodel")
    suspend fun getAllFoods(): List<FoodModel>

    @Query("SELECT * FROM foodmodel WHERE uuid = :foodId")
    suspend fun getFood(foodId: Int): FoodModel

    @Query("DELETE FROM foodmodel")
    suspend fun deleteAllFoods()
}