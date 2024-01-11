package com.android.othermind.ui.fragments.auth.usernamePassword

import com.android.othermind.databinding.FragmentPasswordBinding
import com.android.othermind.ui.fragments.base.BaseFragment

class SetPasswordFragment :
    BaseFragment<FragmentPasswordBinding>(FragmentPasswordBinding::inflate) {
    override fun onViewCreated() {
        binding.layoutToolbar.root.setOnClickListener { backPressed() }
        handleProperUI()
    }
}