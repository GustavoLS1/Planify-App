package com.example.planify.screen.login.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: tokenDto,
    @SerializedName("message") val message: String
)