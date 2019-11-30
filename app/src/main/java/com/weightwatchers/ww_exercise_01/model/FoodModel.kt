package com.weightwatchers.ww_exercise_01.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FoodModel(

        @ColumnInfo(name = "title")
        @SerializedName("title")
        val title: String?,

        @ColumnInfo(name = "image")
        @SerializedName("image")
        val image: String?,


        @ColumnInfo(name = "filter")
        @SerializedName("filter")
        val filter: String?

) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}