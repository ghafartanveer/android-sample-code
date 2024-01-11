package com.android.othermind.ui.fragments.auth.signup

import com.android.othermind.databinding.FragmentSignupStepOneBinding
import com.android.othermind.ui.fragments.auth.main.gradientText
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.goBack
import com.android.othermind.utils.navigate

class SignupStepOne :
    BaseFragment<FragmentSignupStepOneBinding>(FragmentSignupStepOneBinding::inflate) {

    override fun onViewCreated() {
        binding.layoutToolbar.txtStepDesc.gradientText(1)
        binding.layoutToolbar.back.root.setOnClickListener { goBack() }
        binding.layoutContinue.setOnClickListener { navigate(SignupStepOneDirections.toSMSVerificationCode()) }
        handleUI()
    }
}