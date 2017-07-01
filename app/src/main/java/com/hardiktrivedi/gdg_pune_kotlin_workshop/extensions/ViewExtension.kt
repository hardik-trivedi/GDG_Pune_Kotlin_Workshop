package com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.widget.TextView

/**
 * Created by hardik.trivedi on 27/06/17.
 */
var TextView.textColor: Int
    get() = currentTextColor
    set(color) {
        setTextColor(color)
    }

fun Context.color(color: Int): Int = ContextCompat.getColor(this, color)