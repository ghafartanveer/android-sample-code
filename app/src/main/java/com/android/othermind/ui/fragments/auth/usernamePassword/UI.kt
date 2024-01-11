package com.android.othermind.ui.fragments.auth.usernamePassword

import android.text.InputType
import android.text.method.PasswordTransformationMethod
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.android.othermind.R
import com.android.othermind.ui.fragments.auth.main.gradientText
import com.android.othermind.utils.gone
import com.android.othermind.utils.removeEditTextDrawable
import com.android.othermind.utils.visible


fun UsernameLanguageFragment.handleProperUI() {
    binding.layoutToolbar.tvWelcome.text = getString(R.string.more_about_you)
    binding.layoutToolbar.txtStep.text = getString(R.string.step_3)
    binding.layoutToolbar.txtStepDesc.gradientText(2)
    binding.layoutToolbar.txtStepDesc.text = getString(R.string.almost_there)
    binding.layoutToolbar.viewStepOne.setBackgroundResource(R.drawable.ic_selected_indicator)
    binding.layoutToolbar.viewStepTwo.setBackgroundResource(R.drawable.ic_selector_step_two)
    binding.layoutToolbar.viewStepThree.setBackgroundResource(R.drawable.ic_selector_step_three)

    binding.layoutLanguage.txtName.text = getString(R.string.languages)
    binding.layoutLanguage.txtUsername.text = getString(R.string.add_language)
    binding.layoutLanguage.txtUsername.setTextColor(ContextCompat.getColor(requireContext(),
        R.color.blue))
    binding.layoutLanguage.imgProfile.setImageResource(R.drawable.ic_translation)
    binding.layoutLanguage.imgPlus.visible()
    binding.layoutLanguage.txtStatus.gone()
    binding.layoutLanguage.imgAsk.gone()


    val typeface = ResourcesCompat.getFont(context!!, R.font.app_regular)
    binding.layoutLanguage.txtUsername.typeface = typeface
}

fun SetPasswordFragment.handleProperUI() {
    binding.layoutPassword.imgAsk.visible()
    binding.layoutPassword.txtName.text = getString(R.string.password)
    binding.layoutPassword.etName.hint = getString(R.string.enter_password)
    binding.layoutPassword.etName.transformationMethod = PasswordTransformationMethod.getInstance()
    binding.layoutConfirmPassword.etName.transformationMethod = PasswordTransformationMethod.getInstance()
    binding.layoutPassword.etName.removeEditTextDrawable()
    binding.layoutConfirmPassword.txtName.text = getString(R.string.confirm_password)
    binding.layoutConfirmPassword.etName.hint = getString(R.string.enter_password)
    binding.layoutConfirmPassword.etName.removeEditTextDrawable()
}