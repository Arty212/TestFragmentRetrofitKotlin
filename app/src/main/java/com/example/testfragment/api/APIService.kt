package com.example.testfragment.api

import com.example.testfragment.model.Country
import retrofit2.Call
import retrofit2.http.GET


interface APIService {
    @GET("/countries")
    fun getCountries(): Call<ArrayList<Country>?>?
}