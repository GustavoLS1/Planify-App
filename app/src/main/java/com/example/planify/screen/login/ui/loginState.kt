package com.example.planify.screen.login.ui

// sealed class es una clase que se utiliza
// para limitar quienes pueden heredar de ella
// además
sealed class loginState {
    object idle : loginState() // Estado inicial y sin cambios
    object loading : loginState() // Estado de carga
    object success : loginState() // Estado de éxito
    data class error(val message: String) : loginState() // Estado de error con mensaje
}