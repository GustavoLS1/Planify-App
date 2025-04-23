package com.example.planify.screen.login.ui.data.response

import com.google.gson.annotations.SerializedName

data class loginDto (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)