package com.android.othermind.injections

import com.android.othermind.view.models.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        AuthViewModel(get())
    }
}