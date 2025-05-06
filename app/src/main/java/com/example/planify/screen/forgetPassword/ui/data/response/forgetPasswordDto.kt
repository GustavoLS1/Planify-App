package com.example.planify.screen.forgetPassword.ui.data.response

import com.google.gson.annotations.SerializedName

//Código de recuperación
data class RequestResetDto (
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String? = null
)

//Código de verificación recibido
data class VerifyCodeDto (
    @SerializedName("email") val email: String,
    @SerializedName("code") val code: String
)

//Cambio de contraseña
data class ResetPasswordDto (
    @SerializedName("email") val email: String,
    @SerializedName("code") val code: String,
    @SerializedName("newPassword") val newPassword: String
)