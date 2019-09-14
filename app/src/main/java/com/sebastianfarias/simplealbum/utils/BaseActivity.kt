package com.sebastianfarias.simplealbum.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sebastianfarias.simplealbum.R

open class BaseActivity : AppCompatActivity() {

    fun hasInternetConnection(): Boolean {
        val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connManager.activeNetworkInfo
        val connected = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        if(!connected){
            Toast.makeText(this, R.string.general_error_connection, Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}