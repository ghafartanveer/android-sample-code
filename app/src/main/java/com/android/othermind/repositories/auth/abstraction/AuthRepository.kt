package com.android.othermind.repositories.auth.abstraction

import com.android.othermind.models.auth.UserModel
import com.android.othermind.models.base.BaseResponse
import com.mobizion.base.response.NetworkResponse

interface AuthRepository {
    suspend fun login(
        email: String?,
        password: String?
    ): NetworkResponse<BaseResponse<UserModel>>

    suspend fun getFcmToken(): String
}