package com.example.planify.screen.forgetPassword.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseForgetPassword (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: Int?,
    @SerializedName("message") val message: String
)