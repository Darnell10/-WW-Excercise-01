package com.weightwatchers.ww_exercise_01.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.weightwatchers.ww_exercise_01.R


class WW_Splash : AppCompatActivity() {

    private val SPLASHTIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, SPLASHTIME)


    }

}