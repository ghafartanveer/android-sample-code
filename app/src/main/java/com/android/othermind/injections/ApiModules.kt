package com.android.othermind.injections


import com.android.othermind.api.auth.AuthApi
import com.android.othermind.utils.BASE_URL
import com.mobizion.base.remote.buildApi
import org.koin.dsl.module

val apiModules = module {
    single {
        buildApi(AuthApi::class.java, BASE_URL)
    }
}