package com.hellofresh.task2.ui

import androidx.appcompat.app.AppCompatActivity
import com.hellofresh.task2.utils.network.NetworkUtils

internal open class BaseActivity : AppCompatActivity() {

    internal fun onNetworkChange(callback: (Boolean) -> Unit) {
        NetworkUtils.getNetworkStatus(this)
            .observe(this, { isConnected ->
                callback(isConnected)
            })
    }

}