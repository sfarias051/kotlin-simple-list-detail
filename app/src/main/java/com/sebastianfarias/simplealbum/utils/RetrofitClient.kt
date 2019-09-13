package com.sebastianfarias.simplealbum.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit: Retrofit

    init {
         retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.WS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <T> getRetrofitClient(service: Class<T>): T {
        return retrofit.create(service)
    }
}