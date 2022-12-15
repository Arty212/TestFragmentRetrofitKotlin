package com.example.testfragment.presener

import com.example.testfragment.api.APIHelper
import com.example.testfragment.api.APIService
import com.example.testfragment.model.Country
import com.example.testfragment.view.ListCountriesView
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class ListCountriesPresenter : MvpPresenter<ListCountriesView>() {

    private var countries = ArrayList<Country>()
    private var apiService: APIService =
        APIHelper.APIServiceConstructor.create(APIService::class.java)

    init {
        loadCountries()
    }

    fun loadCountries() {
        viewState.showProgress()
        val call = apiService.getCountries()

        call!!.enqueue(object : Callback<ArrayList<Country>?> {
            override fun onResponse(
                call: Call<ArrayList<Country>?>,
                response: Response<ArrayList<Country>?>
            ) {
                if (response.body() != null) {
                    countries = response.body()!!
                    countries.sortBy { country -> country.country }
                    viewState.ok(countries)
                }
            }

            override fun onFailure(call: Call<ArrayList<Country>?>, t: Throwable) {
                viewState.error("Что-то пошло не так...")
            }
        })
    }

}