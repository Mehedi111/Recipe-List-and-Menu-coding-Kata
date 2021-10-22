package com.hellofresh.task2.utils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

object NetworkUtils {
    val TAG: String = NetworkUtils::class.java.simpleName

    fun getNetworkStatus(context: Context): LiveData<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequestBuilder = NetworkRequest.Builder()
        val isAvailableLiveData = MutableLiveData<Boolean>()

        connectivityManager.registerNetworkCallback(
            networkRequestBuilder.build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Timber.tag(TAG).d("Network available")
                    isAvailableLiveData.postValue(true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    Timber.tag(TAG).d("Network lost")
                    isAvailableLiveData.postValue(false)
                }
            })

        return isAvailableLiveData
    }
}