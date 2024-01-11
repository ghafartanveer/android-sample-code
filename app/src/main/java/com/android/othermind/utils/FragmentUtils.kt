package com.android.othermind.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.android.othermind.R
import com.mobizion.base.extension.startNewActivityWithAnimation

fun Fragment.navigate(navDirections: NavDirections) {
    findNavController().navigate(navDirections)
}

fun Fragment.goBack() {
    findNavController().navigateUp()
}

fun <A : Activity> Fragment.startNewActivity(activity: Class<A>) {
    requireActivity().startNewActivityWithAnimation(activity,
        R.anim.slide_in_right,
        R.anim.slide_out_left)
}