package com.android.othermind.utils

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.murgupluoglu.flagkit.FlagKit
import java.io.IOException
import java.io.InputStream


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun EditText.setEditTextDrawable(image: Int) {
    this.setCompoundDrawablesWithIntrinsicBounds(image, 0, 0, 0)
}

fun EditText.removeEditTextDrawable() {
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
}

fun ImageView.loadImage(url: String?) {
    val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
    circularProgressDrawable?.strokeWidth = 5f
    circularProgressDrawable?.centerRadius = 30f
    circularProgressDrawable?.start()
    context?.let {
        if (url != null) {
            Glide.with(it)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(this)
        }
    }
}

fun ImageView.loadCountryFlag(name: String?) {
    context?.let {
        if (name != null)
            this.setImageResource(FlagKit.getResId(context, name))
    }
}


fun Fragment.loadJsonFromAsset(inputStream: InputStream): String? {
    return try {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        String(bytes)
    } catch (e: IOException) {
        null
    }
}

