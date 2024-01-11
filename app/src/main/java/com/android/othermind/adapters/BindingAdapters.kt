package com.android.othermind.adapters

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.android.othermind.R
import com.android.othermind.utils.loadImage

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("isInVisible")
fun bindIsInvisible(view: View, isInVisible: Boolean) {
    view.visibility = if (isInVisible) {
        View.INVISIBLE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("setImage")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("loadImage")
fun loadImages(imageView: ImageView, resource: String) {
    imageView.loadImage(resource)
}

@BindingAdapter("backgroundTintChange")
fun backgroundTint(view: CardView, color: String) {
    val red = Color.parseColor(color)
    view.setCardBackgroundColor(red)
}


