package com.android.othermind.ui.fragments.auth.signup

import com.android.othermind.databinding.FragmentSendSmsVerificationBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.goBack
import com.android.othermind.utils.navigate

class SendVerificationCodeFragment :
    BaseFragment<FragmentSendSmsVerificationBinding>(FragmentSendSmsVerificationBinding::inflate) {

    override fun onViewCreated() {
        binding.layoutToolbar.root.setOnClickListener { backPressed() }
        binding.layoutSendEmail.root.setOnClickListener {
            navigate(SendVerificationCodeFragmentDirections.verificationCodeToCodeConfirmation())
        }
        binding.layoutSendSms.root.setOnClickListener {
            navigate(SendVerificationCodeFragmentDirections.verificationCodeToCodeConfirmation())
        }
        handleUI()
    }
}