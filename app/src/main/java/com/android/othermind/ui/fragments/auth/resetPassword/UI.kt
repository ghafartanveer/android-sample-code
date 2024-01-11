package com.android.othermind.ui.fragments.auth.resetPassword

import android.text.method.PasswordTransformationMethod
import com.android.othermind.R
import com.android.othermind.utils.removeEditTextDrawable
import com.android.othermind.utils.setEditTextDrawable
import com.android.othermind.utils.visible

fun ResetPasswordFragment.handleProperUI() {
    binding.layoutEmail.txtName.text = getString(R.string.email)
    binding.layoutEmail.etName.hint = getString(R.string.enter_email)
    binding.layoutEmail.etName.setEditTextDrawable(R.drawable.ic_mail_outline)
}

fun SetNewPasswordFragment.handleProperUI() {
    binding.txtNeedPassword.text = getString(R.string.enter_new_password)
    binding.layoutPassword.imgAsk.visible()
    binding.layoutPassword.txtName.text = getString(R.string.password)
    binding.layoutPassword.etName.hint = getString(R.string.enter_password)
    binding.layoutPassword.etName.transformationMethod = PasswordTransformationMethod.getInstance()
    binding.layoutConfirmPassword.etName.transformationMethod =
        PasswordTransformationMethod.getInstance()
    binding.layoutPassword.etName.removeEditTextDrawable()
    binding.layoutConfirmPassword.txtName.text = getString(R.string.confirm_password)
    binding.layoutConfirmPassword.etName.hint = getString(R.string.enter_password)
    binding.layoutConfirmPassword.etName.removeEditTextDrawable()
}