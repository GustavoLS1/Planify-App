package com.example.planify.screen.login.ui.data


import com.example.planify.screen.login.ui.data.response.apiResponseDto
import com.example.planify.screen.login.ui.data.response.loginDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface authApiService {
    @POST("auth/login")
    suspend fun getLogin(@Body loginDto: loginDto): Response<apiResponseDto>

}


