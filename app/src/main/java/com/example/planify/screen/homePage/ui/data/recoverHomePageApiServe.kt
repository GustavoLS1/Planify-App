package com.example.planify.screen.homePage.ui.data

import com.example.planify.screen.homePage.ui.data.response.apiResponseHomePage
import com.example.planify.screen.homePage.ui.data.response.apiResponseHomePageTransactions
import com.example.planify.screen.homePage.ui.data.response.transactionCreateResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface recoverHomePageApiServe {
    @POST("/V1/transaction/created")
    suspend fun transactionCreate(@Body homePageDto: transactionCreateResponseDto): Response<apiResponseHomePage>

    @GET("/V1/transaction")
    suspend fun getTransaction(
        @Query("fecha") fecha: String
    ): Response<apiResponseHomePageTransactions>
}