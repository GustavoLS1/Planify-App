package com.example.planify.screen.notebook.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class notebookViewModel: ViewModel() {

    private val _savingsGoal = mutableStateOf(1)
    val savingsGoal: State<Int> = _savingsGoal

    private val _expanded = mutableStateOf(false)
    val expanded: State<Boolean> = _expanded

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _dateGoal = mutableStateOf("")
    val dateGoal: State<String> = _dateGoal

    private val _amount = mutableStateOf(0)
    val amount: State<Int> = _amount

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isCreateEnabled = mutableStateOf(false)
    val isCreateEnabled: State<Boolean> = _isCreateEnabled

    fun onNotebookChange(
        name: String,
        dateGoal: String,
        amount: Int
    ) {
        _name.value = name.take(50)
        _dateGoal.value = dateGoal
        _amount.value = amount
    }

    fun toggleExpanded() {
        _expanded.value = !_expanded.value
    }
}