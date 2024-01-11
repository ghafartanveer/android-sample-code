package com.android.othermind.view.holders

import com.android.othermind.databinding.RvCountryLanguageBinding
import com.android.othermind.models.countries.Countries
import com.android.othermind.utils.loadCountryFlag
import com.mobizion.base.listeners.OnItemSelectedListener
import com.mobizion.base.view.holder.BaseViewHolder

class CountryViewHolder(
    private val binding: RvCountryLanguageBinding,
    private val onCountrySelectedListener: OnItemSelectedListener<Countries>,
) :
    BaseViewHolder<RvCountryLanguageBinding, Countries>(binding) {
    override fun bind(item: Countries, position: Int) {
        binding.model = item

        binding.chkLanguage.isChecked = item.is_selected
        binding.txtCountryName.text = item.countryName()
        binding.imageFlag.loadCountryFlag(item.code)

        itemView.setOnClickListener {
            binding.chkLanguage.isChecked = !item.is_selected
            onCountrySelectedListener.onItemSelected(item, position)
        }
    }
}