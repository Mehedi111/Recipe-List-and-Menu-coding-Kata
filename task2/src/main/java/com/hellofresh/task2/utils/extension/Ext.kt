package com.hellofresh.task2.utils.extension

import android.view.View

internal fun View.show() {
    this.visibility = View.VISIBLE
}

internal fun View.hide() {
    this.visibility = View.GONE
}
