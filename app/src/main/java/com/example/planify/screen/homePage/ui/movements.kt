package com.example.planify.screen.homePage.ui

data class movements(
    val title: String,
    val amount: Double,
    val type: typeMovements
)

enum class typeMovements {
    INCOME, EXPENSE
}