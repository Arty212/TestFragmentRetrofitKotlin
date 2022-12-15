package com.example.testfragment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val HOST_URL = "https://api.covid19api.com"

class APIHelper {
    object APIServiceConstructor {
        @JvmStatic
        fun <T> create(serviceClass: Class<T>?): T {
            val retrofit = Retrofit.Builder()
                .baseUrl(HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(serviceClass!!)
        }
    }
}