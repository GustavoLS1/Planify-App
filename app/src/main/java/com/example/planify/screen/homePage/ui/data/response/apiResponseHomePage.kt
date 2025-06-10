package com.example.planify.screen.homePage.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseHomePage (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: Int?,
    @SerializedName("message") val message: String
)
