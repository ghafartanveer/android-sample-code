package com.android.othermind.ui.fragments.auth.usernamePassword

import com.android.othermind.databinding.FragmentUsernameLanguagueBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.navigate

class UsernameLanguageFragment :
    BaseFragment<FragmentUsernameLanguagueBinding>(FragmentUsernameLanguagueBinding::inflate) {
    override fun onViewCreated() {
        binding.layoutContinue.setOnClickListener { navigate(UsernameLanguageFragmentDirections.usernameLanguageToSetPassword()) }
        binding.layoutToolbar.back.root.setOnClickListener { backPressed() }
        binding.layoutLanguage.txtUsername.setOnClickListener { navigate(UsernameLanguageFragmentDirections.usernameToCountries()) }
        handleProperUI()
    }
}