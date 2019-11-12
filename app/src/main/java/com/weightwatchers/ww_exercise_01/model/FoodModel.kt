package com.weightwatchers.ww_exercise_01.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodModel(

        @ColumnInfo(name = "title")
        val title: String?,

        @ColumnInfo(name = "image")
        val image: String?,

        @ColumnInfo(name = "filter")
        val filter: String?

) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}