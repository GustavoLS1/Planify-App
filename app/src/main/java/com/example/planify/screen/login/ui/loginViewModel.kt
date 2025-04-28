package com.example.planify.screen.login.ui

import android.content.Context
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

    private val _loginState = mutableStateOf<loginState>(loginState.idle)
    val login_State: State<loginState> = _loginState

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage


    fun onLoginChange(email: String, password: String) {
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
        _password.value = password.take(20) // Limita un maximo de 20 caracteres
        _isLoginEnabled.value = enableLoginButton(_email.value, _password.value)
    }


    fun enableLoginButton(email: String, password: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotBlank()
    }

    private fun saveToken(context: Context, token: String){
        val sharedPref = context.getSharedPreferences("PlanifyPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("accessToken", token)
            apply()
        }
    }


    fun login(context: Context) {
        // Verifica si el usuario ha ingresado los campos correctamente y no están vacíos
        // El return se utiliza para salir de la función si los campos no son válidos y salga del login
        if (!enableLoginButton(email.value, password.value)){
            _errorMessage.value = "Por favor, llena todos los campos correctamente."
            return
        }
        viewModelScope.launch {
            _loginState.value = loginState.loading // Cambia el estado a cargando
            try {
                val authService = retrofitHelper.getAuthService()
                val loginDto = loginDto(email.value, password.value)
                val response = authService.getLogin(loginDto)

                if (response.isSuccessful) {
                    val body = response.body()
                    val token = body?.response?.accessToken
                    val message = body?.message

                    if (token != null) {
                        saveToken(
                            context = context,
                            token = token
                        ) // Guarda el token en SharedPreferences
                        Log.d("Login", "Login exitoso: $message")
                        Log.d("Login", "Token: $token")
                        _loginState.value = loginState.success // Cambia el estado a éxito
                    } else {
                        Log.e("Login", "Token vacío o nulo")
                    }
                } else {
                    Log.e("Login", "Error en login: ${response.errorBody()?.string()}")
                    _errorMessage.value = "Error en el inicio de sesión. Inténtalo de nuevo."
                }
            } catch (e: Exception) {
                Log.e("Login", "Excepción: ${e.message}", e)
            }
        }
    }

}