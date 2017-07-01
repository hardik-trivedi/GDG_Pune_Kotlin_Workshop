package com.hardiktrivedi.gdg_pune_kotlin_workshop.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by hardik.trivedi on 24/06/17.
 */

fun Long.toStringDate(expectedFormat: Int = DateFormat.MEDIUM): String {
    val dateFormat = DateFormat.getDateInstance(expectedFormat, Locale.getDefault())
    return dateFormat.format(this)
}