package com.android.othermind.ui.fragments.auth.main

import com.android.othermind.databinding.FragmentStartUpBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.navigate

class StartupFragment : BaseFragment<FragmentStartUpBinding>(FragmentStartUpBinding::inflate) {


    override fun onViewCreated() {
        setVisibility(listOf(
            binding.imgPerson1,
            binding.imgPerson2,
            binding.imgPerson3,
            binding.imgPerson4,
            binding.imgPerson6,
            binding.imgPerson7,
            binding.imgPerson8,
            binding.imgPerson9,
            binding.layoutFooter.root
        ), isVisible = true)
        handleAnimation()

        binding.layoutFooter.txtFuture.gradientText(type = 1)
        binding.layoutFooter.txtSocial.gradientText(type = 2)
        binding.btnLogin.setOnClickListener { navigate(StartupFragmentDirections.startupToLogin()) }
        binding.layoutFooter.btnStart.setOnClickListener { navigate(StartupFragmentDirections.startToWelcome()) }
    }
}