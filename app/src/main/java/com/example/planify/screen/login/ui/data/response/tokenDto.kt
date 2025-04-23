package com.example.planify.screen.login.ui.data.response

import com.google.gson.annotations.SerializedName

data class tokenDto(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("accessToken") val accessToken: String
)