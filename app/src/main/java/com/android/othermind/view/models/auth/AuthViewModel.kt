package com.android.othermind.view.models.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.othermind.models.auth.UserModel
import com.android.othermind.models.base.BaseResponse
import com.android.othermind.repositories.auth.abstraction.AuthRepository
import com.mobizion.base.response.NetworkResponse
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _authResponse: MutableLiveData<NetworkResponse<BaseResponse<UserModel>>> by lazy {
        MutableLiveData()
    }

    val authResponse: LiveData<NetworkResponse<BaseResponse<UserModel>>>
        get() = _authResponse

    fun login(
        email: String?,
        password: String?,
    ) = viewModelScope.launch {
        val fcmToken = repository.getFcmToken()
        _authResponse.value = repository.login(
            email,
            password
        )
    }
}