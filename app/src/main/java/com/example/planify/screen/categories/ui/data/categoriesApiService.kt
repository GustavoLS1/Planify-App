package com.example.planify.screen.categories.ui.data

import com.example.planify.screen.categories.ui.data.response.apiResponseCategories
import com.example.planify.screen.categories.ui.data.response.apiResponseCategoriesList
import com.example.planify.screen.categories.ui.data.response.createCategoryDto
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.GET

interface categoriesApiService {
    @POST("/V1/categories/created")
    suspend fun createCategory(@Body categoryDto: createCategoryDto): Response<apiResponseCategories>

    @GET("/V1/categories")
    suspend fun getCategories(): Response<apiResponseCategoriesList>
}