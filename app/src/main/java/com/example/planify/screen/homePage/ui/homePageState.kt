package com.example.planify.screen.homePage.ui

sealed class homePageState {
    object idle : homePageState()
    object loading : homePageState()
    object success : homePageState()
    data class error(val message: String) : homePageState()
}