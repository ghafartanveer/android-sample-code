package com.android.othermind.models.countries

import java.io.Serializable

class MainCountryModel(
    val status: Int,
    var data: ArrayList<Countries> = ArrayList(),
) : Serializable