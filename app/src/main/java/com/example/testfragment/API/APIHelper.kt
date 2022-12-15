package com.example.testfragment.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HOST_URL = "https://api.covid19api.com"

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