package com.android.othermind.utils

import com.google.gson.Gson
import com.mobizion.base.errors.APIError
import com.mobizion.base.response.NetworkResponse
import retrofit2.HttpException

const val BASE_URL = "https://experts-app.com/api/"

const val LOGIN = "login"

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T,
): NetworkResponse<T> {
    return try {
        NetworkResponse.Success(apiCall.invoke())
    } catch (throwable: Exception) {
        when (throwable) {
            is HttpException -> {
                throwable.parseException()
            }
            else -> {
                NetworkResponse.Failure(
                    false,
                    null,
                    "Check Your Internet Connection"
                )
            }
        }
    }
}

private fun HttpException.parseException(): NetworkResponse.Failure {
    response()?.let { errorResponse ->
        try {
            errorResponse.errorBody()?.let { errorBody ->
                val response = Gson().fromJson(errorBody.charStream(), APIError::class.java)
                return NetworkResponse.Failure(
                    true,
                    response,
                    response.message
                )
            }
        } catch (ex: Exception) {
            return NetworkResponse.Failure(
                true,
                null,
                "Unknown Exception Occurred"
            )
        }
    }
    return NetworkResponse.Failure(
        true,
        null,
        "Unknown Exception Occurred"
    )
}