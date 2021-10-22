package com.hellofresh.task2.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd MMM", Locale.ENGLISH)
        return sdf.format(Date())
    }
}
