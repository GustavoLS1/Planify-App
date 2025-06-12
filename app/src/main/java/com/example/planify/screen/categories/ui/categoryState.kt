package com.example.planify.screen.categories.ui

sealed class categoryState {
    object idle : categoryState()
    object loading : categoryState()
    object success : categoryState()
    data class error(val message: String) : categoryState()
}