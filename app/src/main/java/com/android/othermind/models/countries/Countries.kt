package com.android.othermind.models.countries

import com.android.othermind.utils._ENGLISH
import java.io.Serializable

data class Countries(
    val capital: String,
    val code: String,
    val currency: Currency,
    val flag: String,
    val language: Language,
    val name: String,
    val region: String,
    var is_selected: Boolean,
) : Serializable {
    fun countryName(): String {
        return if (language.name.equals(_ENGLISH, ignoreCase = true)) {
            "${language.name} ($code)"
        } else {
            language.name
        }
    }
}