package com.android.othermind.ui.fragments.auth.login

import android.text.InputType
import com.android.othermind.R
import com.android.othermind.utils.setEditTextDrawable

fun LoginFragment.handleProperUI() {
    binding.layoutEmail.txtName.text = getString(R.string.your_account)
    binding.layoutEmail.etPassword.hint = getString(R.string.username_or_password)
    binding.layoutEmail.etPassword.setEditTextDrawable(R.drawable.ic_user_gradient)
    binding.layoutEmail.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
}