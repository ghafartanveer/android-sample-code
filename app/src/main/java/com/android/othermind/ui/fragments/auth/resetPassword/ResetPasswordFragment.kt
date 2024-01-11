package com.android.othermind.ui.fragments.auth.resetPassword

import com.android.othermind.databinding.FragmentResetPasswordBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.navigate

class ResetPasswordFragment :
    BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate) {
    override fun onViewCreated() {
        binding.layoutToolbar.back.setOnClickListener { backPressed() }
        binding.layoutContinue.setOnClickListener { navigate(ResetPasswordFragmentDirections.resetPasswordToPasswordConfirmation()) }
        handleProperUI()
    }
}