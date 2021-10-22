package com.hellofresh.task2.ui

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hellofresh.task2.R
import com.hellofresh.task2.utils.network.NetworkUtils

internal open class BaseActivity : AppCompatActivity() {

    internal fun onNetworkChange(callback: (Boolean) -> Unit) {
        NetworkUtils.getNetworkStatus(this)
            .observe(this, { isConnected ->
                callback(isConnected)
            })
    }


    internal fun showSnackBar(parentLayout: View?, message: String) {
        parentLayout?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_LONG).apply {
                setAction(getString(R.string.text_ok)) {}
                setActionTextColor(Color.WHITE)
                show()
            }

        }

    }

}