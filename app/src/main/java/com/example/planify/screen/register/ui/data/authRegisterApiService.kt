package com.example.planify.screen.register.ui.data

import com.example.planify.screen.register.ui.data.response.apiResponseRegisterDto
import com.example.planify.screen.register.ui.data.response.registerDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface authRegisterApiService {
    @POST("V1/auth/register")
    suspend fun getRegisterService(@Body registerDto: registerDto): Response<apiResponseRegisterDto>

}