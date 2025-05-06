package com.example.planify.screen.register.ui

sealed class registerState {
    object idle : registerState() // Estado inicial y sin cambios
    object loading : registerState() // Estado de carga
    object success : registerState() // Estado de éxito
    data class error(val message: String) : registerState() // Estado de error con mensaje
}