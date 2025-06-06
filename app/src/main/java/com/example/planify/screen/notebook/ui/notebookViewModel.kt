package com.example.planify.screen.notebook.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class notebookViewModel: ViewModel() {

    private val _goals = mutableStateListOf(
        goal("Viaje", 300, 1000),
        goal("Laptop", 500, 1500),
        goal("Curso de cocina", 200, 800)
    )
    val goals: List<goal> get() = _goals

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

    private val _isModalOpen = mutableStateOf(false)
    val isModalOpen: State<Boolean> = _isModalOpen

    private val _selectedGoal = mutableStateOf<Pair<String, Pair<Int, Int>>?>(null)
    val selectedGoal: State<Pair<String, Pair<Int, Int>>?> = _selectedGoal

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

    fun openAmountModal(nombre: String, actual: Int, total: Int) {
        _selectedGoal.value = nombre to (actual to total)
        _isModalOpen.value = true
    }

    fun closeAmountModal() {
        _isModalOpen.value = false
        _selectedGoal.value = null
    }

    fun toggleExpanded() {
        _expanded.value = !_expanded.value
    }

    /*fun addAmountToMeta(nombre: String, amount: Int) {
        val index = _goals.indexOfFirst { it.nombre == nombre }
        if (index != -1) {
            _goals[index] = _goals[index].copy(actual = _goals[index].actual + amount)
        }
        closeAmountModal()
    }*/

    // Método para actualizar el monto de una meta
    fun addAmountToGoal(meta: goal, monto: Int) {
        val index = _goals.indexOf(meta)
        if (index != -1) {
            val updated = meta.copy(actual = meta.actualState + monto)
            _goals[index] = updated
        }
    }
}