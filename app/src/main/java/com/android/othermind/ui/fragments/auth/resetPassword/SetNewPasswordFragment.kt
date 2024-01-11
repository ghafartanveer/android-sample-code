package com.android.othermind.ui.fragments.auth.resetPassword

import com.android.othermind.databinding.FragmentPasswordBinding
import com.android.othermind.ui.fragments.base.BaseFragment

class SetNewPasswordFragment :BaseFragment<FragmentPasswordBinding>(FragmentPasswordBinding::inflate){
    override fun onViewCreated() {
        binding.layoutToolbar.root.setOnClickListener { backPressed() }
        handleProperUI()
    }
}