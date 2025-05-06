package com.example.planify.screen.register.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseRegisterDto (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: Int?,
    @SerializedName("message") val message: String
)