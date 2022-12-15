package com.example.testfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testfragment.API.APIService

import com.example.testfragment.API.APIServiceConstructor
import com.example.testfragment.databinding.ActivityMainBinding
import com.example.testfragment.model.Country
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var service: APIService
    private lateinit var binding: ActivityMainBinding
    private var countries: ArrayList<Country>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        service = APIServiceConstructor.create(APIService::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (countries == null)
            load()
    }

    private fun load(){
        val call = service.getCountries()

        call!!.enqueue(object: Callback<ArrayList<Country>?>{
            override fun onResponse(
                call: Call<ArrayList<Country>?>, response: Response<ArrayList<Country>?>) {
                if (response.body()!=null){
                    countries = response.body()!!
                    val c = ArrayList<String>()
                    countries!!.forEach { c.add(it.country) }
                    var fragment = ListFragment.newInstance(c)
                }
            }

            override fun onFailure(call: Call<ArrayList<Country>?>, t: Throwable) {
                Snackbar
                    .make(binding.root, "Что-то пошло не так", Snackbar.LENGTH_LONG)
                    .show()
            }

        })
    }
}