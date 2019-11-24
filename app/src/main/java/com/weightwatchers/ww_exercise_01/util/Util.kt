package com.weightwatchers.ww_exercise_01.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.weightwatchers.ww_exercise_01.R

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}


fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable) {

    val option = RequestOptions()
            .placeholder(progressDrawable).error(R.drawable.ww)

    Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
}

@BindingAdapter("android: image")

fun loadImage(view: ImageView, url: String?) {
    view.loadImage(url, getProgressDrawable(view.context))

}