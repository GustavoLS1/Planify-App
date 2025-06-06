package com.example.planify.screen.notebook.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class goal(
    val nombre: String,
    var actual: Int,
    val total: Int
){
    var actualState by mutableStateOf(actual)
}
