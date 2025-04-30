package com.example.planify.screen.forgetPassword.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class forgetPasswordViewModel: ViewModel() {
    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _code = mutableStateOf("")
    val code: State<String> = _code

    private val _currentStep = mutableStateOf(1)
    val currentStep: State<Int> = _currentStep

    private val _isforgetPasswordEnabled = mutableStateOf(false)
    val isforgetPasswordEnabled: State<Boolean> = _isforgetPasswordEnabled

    fun onforgetPasswordChange(
        email: String,
        code: String,
        password: String,
        confirmPassword: String
    ) {
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
        _password.value = password.take(8) // Limita un maximo de 8 caracteres
        _confirmPassword.value = confirmPassword.take(8) // Limita un maximo de 8 caracteres
        _code.value = code.take(6) // Limita un maximo de 6 caracteres
        _isforgetPasswordEnabled.value = enableforgetPasswordButton(
            step = _currentStep.value,
            email = _email.value,
            code = _code.value,
            password = _password.value,
            confirmPassword = _confirmPassword.value)
    }


    fun goToStep(step: Int) {
        _currentStep.value = step
    }

    fun enableforgetPasswordButton(step: Int,email: String,code: String, password: String, confirmPassword: String): Boolean{
        return when(step){
            1 -> android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            2 -> code.length == 6
            3 -> password.isNotBlank() && password == confirmPassword
            else -> false
        }
    }

}