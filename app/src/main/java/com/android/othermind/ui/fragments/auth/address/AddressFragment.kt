package com.android.othermind.ui.fragments.auth.address

import com.android.othermind.databinding.FragmentAddressBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.goBack
import com.android.othermind.utils.navigate

class AddressFragment : BaseFragment<FragmentAddressBinding>(FragmentAddressBinding::inflate) {
    override fun onViewCreated() {
        binding.layoutToolbar.root.setOnClickListener { goBack() }
        binding.txtSkipForNow.setOnClickListener { navigate(AddressFragmentDirections.addressToUsernameLanguage()) }
        handleUI()
    }
}