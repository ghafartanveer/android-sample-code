package com.android.othermind.app

import android.app.Application
import com.android.othermind.injections.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
/**
 * created by ansar abbas
 * Wed 5 Oct, 2022
 */
class OtherMind:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@OtherMind)
            modules(appModules)
        }
    }
}