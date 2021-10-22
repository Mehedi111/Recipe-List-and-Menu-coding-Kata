package com.hellofresh.task2.utils.exception

import androidx.annotation.StringRes
import com.hellofresh.task2.R
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

internal object ExceptionHandler {

    @StringRes
    fun parse(t: Throwable): Int {
        return when (t) {
            is SocketTimeoutException -> {
                // Connection timeout
                R.string.error_timeout
            }
            is UnknownHostException -> {
                // Remote host is currently unreachable
                R.string.error_unable_to_reach
            }
            is IOException -> {
                // A conversion error happened
                R.string.error_data_conversion
            }
            else -> {
                R.string.error_unknown
            }
        }

    }
}