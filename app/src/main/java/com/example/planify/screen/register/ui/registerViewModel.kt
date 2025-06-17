package com.example.planify.screen.register.ui

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.login.ui.data.response.loginDto
import com.example.planify.screen.login.ui.di.retrofitHelper
import com.example.planify.screen.login.ui.loginState
import com.example.planify.screen.register.ui.data.response.registerDto
import com.example.planify.screen.register.ui.di.registerRetrofitHelper
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeParseException

class registerViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _dateOfBirth = mutableStateOf("")
    val dateOfBirth: State<String> = _dateOfBirth

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _registerState = mutableStateOf<registerState>(registerState.idle)
    val register_State: State<registerState> = _registerState

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isRegisterEnabled = mutableStateOf(false)
    val isRegisterEnabled: State<Boolean> = _isRegisterEnabled

    fun onRegisterChange(
        email: String,
        name: String,
        password: String,
        confirmPassword: String,
        dateOfBirth: String,
        number: String
    ) {
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
        _name.value = name.take(50) // Limita un maximo de 50 caracteres
        _password.value = password.take(15) // Limita un maximo de 15 caracteres
        _confirmPassword.value = confirmPassword.take(15) // Limita un maximo de 15 caracteres
        _dateOfBirth.value = dateOfBirth // Asigna la fecha de nacimiento directamente
        _number.value = number.take(10) // Limita un maximo de 10 caracteres
        _isRegisterEnabled.value = enableRegisterButton(
            _email.value,
            _password.value,
            _confirmPassword.value,
            _dateOfBirth.value)
    }

    private fun isValidDate(dateString: String): Boolean {
        return try {
            LocalDate.parse(dateString) // formato ISO-8601: yyyy-MM-dd
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }

    private fun isOldEnough(dateString: String, minimumAge: Int): Boolean {
        return try {
            val birthDate = LocalDate.parse(dateString)
            val today = LocalDate.now()
            val age = today.year - birthDate.year -
                    if (today < birthDate.plusYears((today.year - birthDate.year).toLong())) 1 else 0
            age >= minimumAge
        } catch (e: Exception) {
            false
        }
    }

    fun enableRegisterButton(
        email: String,
        password: String,
        confirmPassword: String,
        dateOfBirth: String
    ): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotBlank() &&
                password == confirmPassword &&
                isValidDate(dateOfBirth) &&
                isOldEnough(dateOfBirth, 18)
    }

    fun resetRegisterState(){
        _registerState.value = registerState.idle
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun register() {
        if (!enableRegisterButton(email.value, password.value, confirmPassword.value, dateOfBirth.value)) {
            _errorMessage.value = "Por favor, llena todos los campos correctamente."
            return
        }
        viewModelScope.launch {
            _registerState.value = registerState.loading // Cambia el estado a cargando
            try {
                val registerDto = registerDto(
                    email = email.value,
                    name = name.value,
                    password = password.value,
                    confirmPassword = confirmPassword.value,
                    dateOfBirth = dateOfBirth.value,
                    number = number.value
                )
                Log.d("Register", "Intentando registrar: $registerDto")
                val authRegisterService = registerRetrofitHelper.getRegisterService()
                val response = authRegisterService.getRegisterService(registerDto)

                if (response.isSuccessful) {
                    val body = response.body()
                    val message = body?.message

                    Log.d("Register", "Registro exitoso: $message")
                    _registerState.value = registerState.success // Cambia el estado a éxito
                } else {
                    Log.e("Register", "Error en registro: ${response.errorBody()?.string()}")
                    _registerState.value = registerState.error("Error en el registro")
                }
            } catch (e: Exception) {
                Log.e("Register", "Excepción: ${e.message}", e)
                _registerState.value = registerState.error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }

}