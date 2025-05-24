package com.example.planify.screen.categories.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class categoriesViewModel:ViewModel() {

    private val _incomeCategories = mutableStateOf(listOf("Salario", "Inversión", "Recompensas"))
    private val _expenseCategories = mutableStateOf(listOf("Comida", "Transporte", "Entretenimiento"))

    private val _categoryName = mutableStateOf("")
    val categoryName: State<String> = _categoryName

    private val _isSaveEnabled = mutableStateOf(false)
    val isSaveEnabled: State<Boolean> = _isSaveEnabled

    private val _selectedType = mutableStateOf("INGRESOS")
    val selectedType: State<String> = _selectedType

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    val displayedCategories: State<List<String>> = derivedStateOf {
        val all = if (_selectedType.value == "INGRESOS") _incomeCategories.value else _expenseCategories.value
        all.filter { it.contains(searchQuery.value, ignoreCase = true) }
    }

    fun onCategoryNameChange(name: String) {
        _categoryName.value = name.take(50) // Limita un maximo de 50 caracteres
        _isSaveEnabled.value = name.isNotBlank()
    }

    fun onQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun setCategoryType(type: String) {
        _selectedType.value = type
    }

    fun addCategory(name: String): Boolean {
        val trimmedName = name.trim()
        if (trimmedName.isBlank()) return false

        return if (_selectedType.value == "INGRESOS") {
            if (!_incomeCategories.value.contains(trimmedName)) {
                _incomeCategories.value = _incomeCategories.value + trimmedName
                true
            } else false
        } else {
            if (!_expenseCategories.value.contains(trimmedName)) {
                _expenseCategories.value = _expenseCategories.value + trimmedName
                true
            } else false
        }
    }
}