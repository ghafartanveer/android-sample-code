package com.android.othermind.repositories.data.abstraction

import com.android.othermind.models.auth.UserModel
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun putString(key: String, value: String)
    suspend fun putInt(key: String, value: Int)
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun getBoolean(key: String): Boolean
    suspend fun getString(key: String): String
    suspend fun getInt(key: String): Int?
    suspend fun changeLanguage()
    suspend fun saveUserInfo(user: UserModel, token: String)
    suspend fun clearData()
    suspend fun getToken(): String
    suspend fun getFcmToken(): String
    val user: Flow<UserModel>
    val token: Flow<String>
    val language: Flow<String>
}