package com.android.othermind.adapters.country

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.othermind.databinding.RvCountryLanguageBinding
import com.android.othermind.models.countries.Countries
import com.android.othermind.utils.diff.CountryDiffUtil
import com.android.othermind.view.holders.CountryViewHolder
import com.mobizion.base.adapter.BaseListAdapter
import com.mobizion.base.listeners.OnItemSelectedListener

class CountriesAdapter(
    private val onItemSelectedListener: OnItemSelectedListener<Countries>,
) : BaseListAdapter<Countries, CountryDiffUtil>(CountryDiffUtil()) {
    override fun onViewHolderBind(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CountryViewHolder).bind(getItem(position), position)
    }

    override fun onViewHolderCreate(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(
            RvCountryLanguageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemSelectedListener
        )
}