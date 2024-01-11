package com.android.othermind.ui.activities.startup

import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.android.othermind.databinding.ActivityStartupBinding
import com.android.othermind.ui.activities.auth.AuthActivity
import com.mobizion.base.activity.BaseActivity
import com.mobizion.base.extension.startNewActivity


class StartupActivity : BaseActivity<ActivityStartupBinding>(ActivityStartupBinding::inflate) {
    override fun initViews() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        Handler(Looper.getMainLooper()).postDelayed({
            startNewActivity(AuthActivity::class.java)
        }, 2000)
    }

    override fun shouldHideKeyboard() = true


}