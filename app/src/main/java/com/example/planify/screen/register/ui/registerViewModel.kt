package com.example.planify.screen.register.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class registerViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _isRegisterEnabled = mutableStateOf(false)
    val isRegisterEnabled: State<Boolean> = _isRegisterEnabled

    fun onRegisterChange(email: String, password: String, confirmPassword: String) {
        _email.value = email
        _password.value = password
        _confirmPassword.value = confirmPassword
        _isRegisterEnabled.value = enableRegisterButton(email, password, confirmPassword)
    }

    fun enableRegisterButton(email: String, password: String, confirmPassword: String) =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6 && password == confirmPassword
}