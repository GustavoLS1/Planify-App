package com.example.planify.screen.profile.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class profileViewModel: ViewModel() {

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _currentPassword = mutableStateOf("")
    val currentPassword: State<String> = _currentPassword

    private val _newPassword = mutableStateOf("")
    val newPassword: State<String> = _newPassword

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    fun onProfileChange(
        name: String,
        number: String,
        email: String
    ){
        _name.value = name.take(50) // Limita un maximo de 50 caracteres
        _number.value = number.take(10) // Limita un maximo de 10 caracteres
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
    }

    fun onProfilePasswordChange(
        currentPassword: String,
        newPassword: String,
        confirmPassword: String
    ){
        _currentPassword.value = currentPassword.take(10)
        _newPassword.value = newPassword.take(10)
        _confirmPassword.value = confirmPassword.take(10)
    }
}