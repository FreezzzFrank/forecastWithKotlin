package com.layneyiu.forecast.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * ---------------------------------------------------------
 * View Context Extension
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}