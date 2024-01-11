package com.android.othermind.ui.fragments.auth.signup

import androidx.core.content.ContextCompat
import com.android.othermind.R
import com.android.othermind.ui.fragments.auth.main.gradientText
import com.android.othermind.utils.gone
import com.android.othermind.utils.loadImage
import com.android.othermind.utils.setEditTextDrawable

fun SignupStepOne.handleUI() {
    binding.layoutToolbar.viewStepOne.setBackgroundResource(R.drawable.ic_selected_indicator)
    binding.layoutEmail.txtName.text = getString(R.string.email)
    binding.layoutEmail.etName.hint = getString(R.string.enter_email)
    binding.layoutEmail.etName.setEditTextDrawable(R.drawable.ic_mail_outline)
}


fun SendVerificationCodeFragment.handleUI() {
    binding.layoutSendSms.txtName.text = getString(R.string.send_via_sms)
    binding.layoutSendSms.txtNumber.text = "+1 425 55 7589"
    binding.layoutSendSms.imgProfile.setImageResource(R.drawable.ic_sms)
    binding.layoutSendEmail.txtName.text = getString(R.string.send_via_email)
    binding.layoutSendEmail.txtNumber.text = "evhouse@othermind.com"
    binding.layoutSendEmail.txtNumber.setTextColor(ContextCompat.getColor(requireContext(),R.color.blue))
}

fun CodeConfirmationFragment.handleUI() {
    binding.layoutToolbar.txtStep.gone()
    binding.layoutToolbar.txtStepDesc.gradientText(2)
    binding.layoutToolbar.txtStepDesc.text = "We've sent a 6-digits confirmation to your number"
    binding.layoutToolbar.viewStepOne.setBackgroundResource(R.drawable.ic_selected_indicator)
}