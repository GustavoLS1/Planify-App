package com.example.planify.screen.homePage.ui.data.response

import com.google.gson.annotations.SerializedName

data class transactionCreateResponseDto(
    @SerializedName("amount") val amount: Double,
    @SerializedName("categoryId") val categoryId: Int,
    @SerializedName("description") val description: String
)