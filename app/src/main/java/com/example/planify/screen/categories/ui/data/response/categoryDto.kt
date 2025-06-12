package com.example.planify.screen.categories.ui.data.response

import com.google.gson.annotations.SerializedName

data class categoryDto (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("flowTypeId") val flowTypeId: Int,
    @SerializedName("flowTypeName") val flowTypeName: String,
    @SerializedName("userId") val userId: Int,
    @SerializedName("fixed") val fixed: Boolean
)

data class createCategoryDto (
    @SerializedName("name") val name: String,
    @SerializedName("isFixed") val isFixed: Boolean,
    @SerializedName("flowTypeId") val flowTypeId: Int
)