package com.android.othermind.utils.diff

import com.android.othermind.models.countries.Countries
import com.mobizion.base.utils.BaseDiffUtil

class CountryDiffUtil : BaseDiffUtil<Countries>() {
    override fun areContentsTheSame(oldItem: Countries, newItem: Countries) = oldItem.code == newItem.code

}