package com.android.othermind.injections

import com.android.othermind.repositories.auth.abstraction.AuthRepository
import com.android.othermind.repositories.auth.implementation.AuthRepoImpl
import com.android.othermind.repositories.data.abstraction.DataStoreRepository
import com.android.othermind.repositories.data.implementation.DataStoreRepoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoriesModules = module {
    single<DataStoreRepository> {
        DataStoreRepoImpl(androidContext())
    }
    single<AuthRepository> {
        AuthRepoImpl(get(), get())
    }
}