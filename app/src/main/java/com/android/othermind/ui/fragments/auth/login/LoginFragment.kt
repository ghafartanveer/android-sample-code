package com.android.othermind.ui.fragments.auth.login

import com.android.othermind.databinding.FragmentLoginBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.navigate

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun onViewCreated() {
        handleProperUI()
        binding.back.root.setOnClickListener { backPressed() }
        binding.layoutSocialLink.txtResetPassword.setOnClickListener { navigate(LoginFragmentDirections.loginToResetPassword()) }
    }
}