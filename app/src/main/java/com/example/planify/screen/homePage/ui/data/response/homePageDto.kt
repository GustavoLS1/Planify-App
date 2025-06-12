package com.example.planify.screen.homePage.ui.data.response

import com.example.planify.screen.categories.ui.data.response.categoryDto
import com.google.gson.annotations.SerializedName

data class transactionCreateResponseDto(
    @SerializedName("amount") val amount: Double,
    @SerializedName("categoryId") val categoryId: Int,
    @SerializedName("description") val description: String
)

data class transactionResponseDto(
    @SerializedName("amount") val amount: Double,
    @SerializedName("categoryId") val category: categoryDto,
    @SerializedName("description") val description: String
)