package com.example.planify.screen.forgetPassword.ui.data

import com.example.planify.screen.forgetPassword.ui.data.response.RequestResetDto
import com.example.planify.screen.forgetPassword.ui.data.response.ResetPasswordDto
import com.example.planify.screen.forgetPassword.ui.data.response.VerifyCodeDto
import com.example.planify.screen.forgetPassword.ui.data.response.apiResponseForgetPassword
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface recoverPasswordApiService {
    @POST("/recover-password/verify-code")
    suspend fun requestReset(@Body forgetPasswordDto: RequestResetDto): Response<apiResponseForgetPassword>

    @POST("/recover-password/reset-password")
    suspend fun verifyCode(@Body forgetPasswordDto: VerifyCodeDto): Response<apiResponseForgetPassword>

    @POST("/recover-password/request-reset")
    suspend fun resetPassword(@Body forgetPasswordDto: ResetPasswordDto): Response<apiResponseForgetPassword>
}