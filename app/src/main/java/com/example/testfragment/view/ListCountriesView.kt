package com.example.testfragment.view

import com.example.testfragment.model.Country
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface ListCountriesView : MvpView {
    @Skip
    fun showProgress()

    @AddToEndSingle
    fun ok(countries: ArrayList<Country>)

    @Skip
    fun error(msg: String)
}