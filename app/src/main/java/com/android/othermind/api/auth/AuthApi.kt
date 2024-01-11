package com.android.othermind.api.auth

import com.android.othermind.models.auth.LoginRequest
import com.android.othermind.models.auth.UserModel
import com.android.othermind.models.base.BaseResponse
import com.android.othermind.utils.CONTENT_TYPE
import com.android.othermind.utils.LOGIN
import com.mobizion.base.utils.ACCEPT
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @Headers(ACCEPT, CONTENT_TYPE)
    @POST(LOGIN)
    suspend fun login(
        @Body request: LoginRequest,
    ): BaseResponse<UserModel>
}