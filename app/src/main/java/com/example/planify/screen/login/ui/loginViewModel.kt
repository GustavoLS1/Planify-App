package com.example.planify.screen.login.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.login.ui.data.response.loginDto
import com.example.planify.screen.login.ui.di.retrofitHelper
import kotlinx.coroutines.launch

class loginViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _isLoginEnabled = mutableStateOf(false)
    val isLoginEnabled: State<Boolean> = _isLoginEnabled


    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLoginButton(email, password)
    }


    fun enableLoginButton(email: String, password: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotBlank()
    }


    fun login() {
        viewModelScope.launch {
            try {
                val authService = retrofitHelper.getAuthService()
                val loginDto = loginDto(email.value, password.value)
                val response = authService.getLogin(loginDto)

                if (response.isSuccessful) {
                    val body = response.body()
                    val token = body?.response?.accessToken
                    val message = body?.message

                    Log.d("Login", "Login exitoso: $message")
                    Log.d("Login", "Token: $token")
                } else {
                    Log.e("Login", "Error en login: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("Login", "Excepción: ${e.message}", e)
            }
        }
    }

}