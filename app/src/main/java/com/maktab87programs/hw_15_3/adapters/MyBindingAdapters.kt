package com.maktab87programs.hw_15_3

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(photoUrl: String) {
    Glide.with(this.context)
        .load(photoUrl)
         // For part 1
        .placeholder(R.drawable.no_image)
        //For part 2
        .placeholder(R.drawable.loading_animation)
        .into(this)

}