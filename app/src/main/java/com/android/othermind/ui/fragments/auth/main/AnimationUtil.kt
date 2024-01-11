package com.android.othermind.ui.fragments.auth.main

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.android.othermind.R
import com.android.othermind.utils.visible
import com.mobizion.base.extension.invisible

fun StartupFragment.handleAnimation() {
    setAnimation(listOf(
        binding.imgPerson1,
        binding.imgPerson2,
        binding.imgPerson3,
        binding.imgPerson4,
        binding.imgPerson6,
        binding.imgPerson7,
        binding.imgPerson8,
        binding.imgPerson9
    ))
}

fun StartupFragment.setAnimation(images: List<View>) {
    val animRotate = AnimationUtils.loadAnimation(context, R.anim.slide_up)
    binding.imgPerson5.startAnimation(animRotate)
    animRotate.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(p0: Animation?) {
        }

        override fun onAnimationEnd(p0: Animation?) {
            setVisibility(images, isVisible = false)
            images.forEach { image -> this@setAnimation.anim(image) }
        }

        override fun onAnimationRepeat(p0: Animation?) {
        }
    })
}

fun StartupFragment.anim(imageView: View) {
    var number = 0
    val animBounce = AnimationUtils.loadAnimation(context, R.anim.slide_up)
    imageView.startAnimation(animBounce)
    animBounce.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            val animRotate = when (imageView) {
                binding.imgPerson2,
                binding.imgPerson6,
                binding.imgPerson8,
                -> {
                    AnimationUtils.loadAnimation(context, R.anim.rotate_up_down)
                }
                else -> {
                    AnimationUtils.loadAnimation(context, R.anim.move)
                }
            }
            imageView.startAnimation(animRotate)
//            binding.imgPerson5.startAnimation(AnimationUtils.loadAnimation(context, R.anim.move))
            moveRandomly(R.anim.move)
            //////////// FOOTER /////////////
            binding.layoutFooter.root.visible()
            binding.btnLogin.visible()

            fadInAnimation()
        }
    })
}

private fun StartupFragment.fadInAnimation() {
    val anim = AnimationUtils.loadAnimation(context, R.anim.rotate)
    binding.layoutFooter.root.startAnimation(anim)
}

private fun StartupFragment.moveRandomly(anim: Int) {
    val animation = AnimationUtils.loadAnimation(context, anim)
    binding.imgPerson5.startAnimation(animation)
}

fun setVisibility(list: List<View>, isVisible: Boolean) {
    list.forEach { image ->
        image.invisible(isVisible)
    }
}

