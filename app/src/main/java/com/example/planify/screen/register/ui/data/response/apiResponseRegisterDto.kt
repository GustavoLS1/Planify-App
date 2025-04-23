package com.example.planify.screen.register.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseRegisterDto (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: registerDto?,
    @SerializedName("message") val message: String
)