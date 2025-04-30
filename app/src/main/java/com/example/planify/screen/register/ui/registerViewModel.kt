package com.example.planify.screen.register.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.register.ui.data.response.registerDto
import com.example.planify.screen.register.ui.di.registerRetrofitHelper
import kotlinx.coroutines.launch
import java.time.LocalDate

class registerViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _isRegisterEnabled = mutableStateOf(false)
    val isRegisterEnabled: State<Boolean> = _isRegisterEnabled

    fun onRegisterChange(
        email: String,
        name: String,
        password: String,
        confirmPassword: String,
        number: String
    ) {
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
        _name.value = name.take(50) // Limita un maximo de 50 caracteres
        _password.value = password.take(8) // Limita un maximo de 8 caracteres
        _confirmPassword.value = confirmPassword.take(8) // Limita un maximo de 8 caracteres
        _number.value = number.take(10) // Limita un maximo de 10 caracteres
        _isRegisterEnabled.value = enableRegisterButton(_email.value, _password.value, _confirmPassword.value)
    }


    fun enableRegisterButton(email: String, password: String, confirmPassword: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotBlank() && password == confirmPassword

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun register() {
        viewModelScope.launch {
            try {
                val registerDto = registerDto(
                    email = email.value,
                    name = name.value,
                    password = password.value,
                    confirmPassword = confirmPassword.value,
                    dateOfBirth = LocalDate.now().toString(),
                    number = number.value
                )
                val authRegisterService = registerRetrofitHelper.getRegisterService()
                val response = authRegisterService.getRegisterService(registerDto)

                if (response.isSuccessful) {
                    val body = response.body()
                    val message = body?.message

                    Log.d("Register", "Registro exitoso: $message")
                } else {
                    Log.e("Register", "Error en registro: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("Register", "Excepción: ${e.message}", e)
            }
        }
    }

}