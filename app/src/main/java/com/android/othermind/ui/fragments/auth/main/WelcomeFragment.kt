package com.android.othermind.ui.fragments.auth.main

import com.android.othermind.R
import com.android.othermind.databinding.FragmentWelcomeBinding
import com.android.othermind.ui.fragments.base.BaseFragment
import com.android.othermind.utils.goBack
import com.android.othermind.utils.gone
import com.android.othermind.utils.navigate

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {


    override fun onViewCreated() {
        binding.txtOtherMind.gradientText(type = 2)
        binding.layoutNewUser.txtName.text = getString(R.string.new_user)
        binding.layoutNewUser.view.setBackgroundResource(R.drawable.ic_gradient_button_pink)
        binding.layoutNewUser.imgArrow.gone()

        binding.layoutReferral.imgProfile.setImageResource(R.drawable.ic_refferal)

        binding.back.root.setOnClickListener { goBack() }
        binding.layoutNewUser.root.setOnClickListener {
            navigate(WelcomeFragmentDirections.welcometoStepOne())
        }
//        binding.layoutReferral.root.setOnClickListener { navigate(WelcomeFragmentDirections.welcomeToReferFriend()) }
    }
}