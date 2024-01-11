package com.android.othermind.ui.fragments.auth.address

import com.android.othermind.R
import com.android.othermind.ui.fragments.auth.main.gradientText

fun AddressFragment.handleUI() {
    binding.layoutToolbar.tvWelcome.text = getString(R.string.address)
    binding.layoutToolbar.txtStep.text = getString(R.string.step_2)
    binding.layoutToolbar.txtStepDesc.gradientText(2)
    binding.layoutToolbar.txtStepDesc.text = getString(R.string.your_address)
    binding.layoutToolbar.viewStepOne.setBackgroundResource(R.drawable.ic_selected_indicator)
    binding.layoutToolbar.viewStepTwo.setBackgroundResource(R.drawable.ic_selector_step_two)
}