package com.example.planify.screen.login.ui

import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class loginViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email : State<String> = _email

    private val _password = mutableStateOf("")
    val password : State<String> = _password

    private val _isLoginEnabled = mutableStateOf(false)
    val isLoginEnabled : State<Boolean> = _isLoginEnabled

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLoginButton(email, password)
    }

    fun enableLoginButton(email:String, password:String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6

}