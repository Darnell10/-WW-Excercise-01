package com.weightwatchers.ww_exercise_01.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class SharedPreferenceHelper {

    companion object {

        private const val PREF_TIME = "Pref time"
        private var prefs: SharedPreferences? = null

        @Volatile
        private var instance: SharedPreferenceHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): SharedPreferenceHelper =
                instance ?: synchronized(LOCK){
                    instance ?: builderHelper(context).also {
                        instance = it
                    }
                }

        private fun builderHelper(context: Context) : SharedPreferenceHelper{
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferenceHelper()
        }


        fun saveUpdateTime(time: Long){
            prefs?.edit(true){
                putLong(PREF_TIME,time)
            }
        }

        fun getUpdateTime() = prefs?.getLong(PREF_TIME,0)


    }
}