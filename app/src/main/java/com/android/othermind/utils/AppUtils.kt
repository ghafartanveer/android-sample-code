package com.android.othermind.utils

import android.content.ContentResolver
import android.content.Context
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Patterns
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.othermind.models.base.BaseResponse
import com.bumptech.glide.Glide
import com.mobizion.base.decorator.SpacesItemDecoration
import com.mobizion.base.extension.showErrorSnackBar
import com.mobizion.base.response.NetworkResponse


const val ENGLISH = "en"
const val ARABIC = "ar"
const val _ENGLISH = "English"

fun String.isvalidEmail(): Boolean {
    return isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun AppCompatImageView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}
fun AppCompatImageView.loadImage(url: Int?) {
    Glide.with(this)
        .load(url)
        .into(this)
}

fun RecyclerView.setGalleryManager() {
    this.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
    val decoration = SpacesItemDecoration(5)
    this.addItemDecoration(decoration)
}

fun <T> NetworkResponse<BaseResponse<T>>.getResponseFromBaseResponse(view: View): BaseResponse<T>? {
    return when (this) {
        is NetworkResponse.Success -> {
            if (this.value.status) {
                this.value
            } else {
                view.showErrorSnackBar(this.value.message)
                null
            }
        }
        is NetworkResponse.Failure -> {
            this.message?.let { message ->
                view.showErrorSnackBar(message)
            }
            null
        }
    }
}

/**
 * Convenience extension method to register a [ContentObserver] given a lambda.
 */
fun ContentResolver.registerObserver(
    uri: Uri,
    observer: (selfChange: Boolean) -> Unit,
): ContentObserver {
    val contentObserver = object : ContentObserver(null) {
        override fun onChange(selfChange: Boolean) {
            observer(selfChange)
        }
    }
    registerContentObserver(uri, true, contentObserver)
    return contentObserver
}

fun Context.getPath(uri: Uri): String {
    val projection = arrayOf(MediaStore.Images.Media.DATA)
    val cursor: Cursor? = this.contentResolver.query(
        uri, projection, null, null,
        null
    )
    if (cursor != null) {
        val columnIndex = cursor
            .getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val path = cursor.getString(columnIndex)
        cursor.close()
        return path
    }
    return ""
}

fun Int.percentage(total: Int): Double {
    return (toDouble() / total) * 100
}

