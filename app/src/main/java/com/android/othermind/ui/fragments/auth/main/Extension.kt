package com.android.othermind.ui.fragments.auth.main

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.TextPaint
import android.widget.TextView


fun TextView.gradientText(type : Int = 1) {
     val colors = if (type == 1){
        intArrayOf(Color.parseColor("#2977bb"),Color.parseColor("#8956d2"),Color.parseColor("#e91eac"))
    }else{
        intArrayOf(Color.parseColor("#009dff"),Color.parseColor("#ae41c7"),Color.parseColor("#e91eac"))
    }
    val paint: TextPaint = this.paint
    val width = paint.measureText(this.text.toString())

    val textShader = LinearGradient(0f, 0f, width, this.textSize, colors, null, Shader.TileMode.CLAMP)
    this.paint.shader = textShader
}

