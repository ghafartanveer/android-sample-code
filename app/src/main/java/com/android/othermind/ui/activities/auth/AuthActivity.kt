package com.android.othermind.ui.activities.auth

import android.view.WindowManager
import com.android.othermind.databinding.ActivityAuthBinding
import com.mobizion.base.activity.BaseActivity

class AuthActivity : BaseActivity<ActivityAuthBinding>(ActivityAuthBinding::inflate) {
    override fun initViews() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun shouldHideKeyboard() = true

}