package com.android.othermind.ui.fragments.auth.resetPassword

import com.android.othermind.databinding.FragmentEmailConfirmationBinding
import com.android.othermind.ui.fragments.auth.main.gradientText
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.navigate

class PasswordConfirmationFragment : BaseFragment<FragmentEmailConfirmationBinding>(FragmentEmailConfirmationBinding::inflate) {
    override fun onViewCreated() {
        binding.txtStepDesc.gradientText(2)
        binding.layoutToolbar.back.setOnClickListener { backPressed() }
        binding.layoutSendAgain.setOnClickListener { navigate(PasswordConfirmationFragmentDirections.toSetNewPassword()) }
    }
}