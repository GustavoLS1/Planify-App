package com.example.planify.screen.register.ui.data.response

import com.google.gson.annotations.SerializedName


data class registerDto(
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String,
    @SerializedName("confirmPassword") val confirmPassword: String,
    @SerializedName("dateOfBirth") val dateOfBirth: String,
    @SerializedName("phoneNumber") val number: String
)