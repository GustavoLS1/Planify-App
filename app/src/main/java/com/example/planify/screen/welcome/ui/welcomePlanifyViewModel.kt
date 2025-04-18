package com.example.planify.screen.welcome.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class welcomePlanifyViewModel : ViewModel()  {
    private val _currentStep = mutableStateOf(1)
    val currentStep: State<Int> = _currentStep

    fun setStep(step: Int) {
        _currentStep.value = step
    }
}