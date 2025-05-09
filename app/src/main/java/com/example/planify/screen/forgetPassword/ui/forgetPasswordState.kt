package com.example.planify.screen.forgetPassword.ui

sealed class forgetPasswordState {
    object idle : forgetPasswordState()
    object loading : forgetPasswordState()
    object success : forgetPasswordState()
    data class error(val message: String) : forgetPasswordState()
}