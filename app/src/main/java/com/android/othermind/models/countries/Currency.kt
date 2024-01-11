package com.android.othermind.models.countries

import java.io.Serializable

data class Currency(
    val code: String,
    val name: String,
    val symbol: Any,
) : Serializable