package com.android.othermind.ui.fragments.auth.usernamePassword

import com.android.othermind.R
import com.android.othermind.adapters.country.CountriesAdapter
import com.android.othermind.databinding.FragmentLanguagesBinding
import com.android.othermind.models.countries.Countries
import com.android.othermind.models.countries.MainCountryModel
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.loadJsonFromAsset
import com.google.gson.Gson
import com.mobizion.base.listeners.OnItemSelectedListener


class CountriesFragment : BaseFragment<FragmentLanguagesBinding>(FragmentLanguagesBinding::inflate),
    OnItemSelectedListener<Countries> {
    val countries = ArrayList<Countries>()
    lateinit var countryAdapter: CountriesAdapter

    override fun onViewCreated() {
        loadCountries()
        binding.layoutToolbar.back.setOnClickListener { backPressed() }
        countryAdapter = CountriesAdapter(this@CountriesFragment)
        binding.rvCountry.run { adapter = countryAdapter }
        countryAdapter.submitList(countries)
    }

    private fun loadCountries() {
        val myJson = loadJsonFromAsset(context?.resources!!.openRawResource(R.raw.language))
        val countryModel = Gson().fromJson(myJson, MainCountryModel::class.java)
        countries.clear()
        countries.addAll(countryModel.data)
    }

    override fun onItemSelected(media: Countries, position: Int) {
        countries[position].is_selected = countries[position].is_selected.not()
        countryAdapter.notifyItemChanged(position)
        binding.txtLanguage.text = "(${countries.count { it.is_selected }}) Add languages"

    }
}