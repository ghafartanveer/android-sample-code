package com.android.othermind.repositories.auth.implementation

import android.util.Log
import com.android.othermind.api.auth.AuthApi
import com.android.othermind.models.auth.LoginRequest
import com.android.othermind.models.auth.UserModel
import com.android.othermind.models.base.BaseResponse
import com.android.othermind.repositories.auth.abstraction.AuthRepository
import com.android.othermind.repositories.data.abstraction.DataStoreRepository
import com.mobizion.base.repositories.BaseRepository
import com.mobizion.base.response.NetworkResponse

class AuthRepoImpl(private val api: AuthApi, private val repository: DataStoreRepository) :
    AuthRepository, BaseRepository() {
    override suspend fun login(
        email: String?,
        password: String?,
    ): NetworkResponse<BaseResponse<UserModel>> = safeApiCall { api.login(LoginRequest(email)) }

    override suspend fun getFcmToken(): String {
        var fcmToken = repository.getToken()
        if (fcmToken.isEmpty()) {
            try {
//                fcmToken = FirebaseMessaging.getInstance().token.await()
            } catch (exception: Exception) {
                Log.v("Exception", "Unknown Error occurred")
            }
        }
        return fcmToken
    }

}