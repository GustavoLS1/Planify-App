package com.example.planify.screen.categories.ui.data.response

import com.google.gson.annotations.SerializedName

data class apiResponseCategories (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: categoryDto,
    @SerializedName("message") val message: String
)

data class apiResponseCategoriesList (
    @SerializedName("success") val success: Boolean,
    @SerializedName("response") val response: List<categoryDto>,
    @SerializedName("message") val message: String
)