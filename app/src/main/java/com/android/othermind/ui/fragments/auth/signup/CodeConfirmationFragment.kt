package com.android.othermind.ui.fragments.auth.signup

import com.android.othermind.databinding.FragmentConfirmationSmsBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.goBack
import com.android.othermind.utils.navigate

class CodeConfirmationFragment :
    BaseFragment<FragmentConfirmationSmsBinding>(FragmentConfirmationSmsBinding::inflate) {

    override fun onViewCreated() {
        binding.layoutToolbar.back.root.setOnClickListener { goBack() }
        binding.otpView.setOnFinishListener {
            navigate(CodeConfirmationFragmentDirections.codeConfirmationToAddress())
        }
        handleUI()
    }
}