package com.example.testfragment.model

import com.google.gson.annotations.SerializedName

class Country {
    @SerializedName("Country")
    var country = ""

    @SerializedName("Slug")
    var slug = ""

    @SerializedName("ISO2")
    var iso2 = ""

    override fun toString(): String {
        return country
    }
}