package com.android.othermind.models.base

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

const val MESSAGE = "message"
const val STATUS = "status"
const val ERRORS = "errors"
const val DATA = "data"
const val TOKEN = "token"

data class BaseResponse<T>(
    @SerializedName(MESSAGE)
    var message: String = "",
    @SerializedName(TOKEN)
    var token:String = "",
    @SerializedName(STATUS)
    var status:Boolean = false,
    @SerializedName(ERRORS)
    var errors:List<String> = listOf(),
    @SerializedName(DATA)
    var data:T
):Serializable
