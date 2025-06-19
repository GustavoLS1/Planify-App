package com.example.planify.screen.categories.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.categories.ui.data.response.categoryDto
import com.example.planify.screen.categories.ui.data.response.createCategoryDto
import com.example.planify.screen.categories.ui.di.categoryRetrofitHelper
import kotlinx.coroutines.launch

class categoriesViewModel:ViewModel() {

    private val _incomeCategories = mutableStateOf<List<categoryDto>>(emptyList())
    val incomeCategories: State<List<categoryDto>> get() = _incomeCategories

    private val _expenseCategories = mutableStateOf<List<categoryDto>>(emptyList())
    val expenseCategories: State<List<categoryDto>> get() = _expenseCategories

    private val _categoryName = mutableStateOf("")
    val categoryName: State<String> = _categoryName

    private val _isSaveEnabled = mutableStateOf(false)
    val isSaveEnabled: State<Boolean> = _isSaveEnabled

    private val _selectedType = mutableStateOf("INGRESOS")
    val selectedType: State<String> = _selectedType

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _category_State = mutableStateOf<categoryState>(categoryState.idle)
    val category_State: State<categoryState> = _category_State

    val displayedCategories: State<List<categoryDto>> = derivedStateOf {
        val categories  = if (_selectedType.value == "INGRESOS") _incomeCategories.value else _expenseCategories.value
        val filter = categories.filter {
            it.name.contains(searchQuery.value, ignoreCase = true) &&
                    it.flowTypeName.equals(selectedType.value, ignoreCase = true) }
        // Log.d("DropdownDebug", "Mostrando ${filter.size} categorías")
        filter
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

    fun loadCategories(context: Context) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val service = categoryRetrofitHelper.getCategoryService(context)
                val response = service.getCategories()

                if(response.isSuccessful && response.body()?.success == true){
                    val allCategories = response.body()!!.response
                    Log.d("CategoriesViewModel", "Categorías recibidas: ${allCategories.size}")
                    allCategories.forEach {
                        Log.d("CategoriesDebug", "name=${it.name}, flowTypeName=${it.flowTypeName}, fixed=${it.fixed}")
                    }
                    _incomeCategories.value = allCategories.filter { it.flowTypeName.uppercase() == "INGRESOS" }
                    _expenseCategories.value = allCategories.filter { it.flowTypeName.uppercase() == "GASTOS" }
                    _errorMessage.value = null
                }else{
                    _errorMessage.value = response.body()?.message ?: "Error al cargar las categorías"
                }
            }catch (e: Exception){
                _errorMessage.value = "Error de conexión: ${e.message}"
                Log.e("CategoriesViewModel", "loadCategories: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }

    }

    fun createCategory(context: Context) {
        val name = _categoryName.value.trim()
        val flowTypeId = if (_selectedType.value == "INGRESOS") 2 else 1

        if (name.isBlank()) return

        _category_State.value = categoryState.loading

        viewModelScope.launch {
            try {
                val service = categoryRetrofitHelper.getCategoryService(context)
                val dto = createCategoryDto(name = name, isFixed = false, flowTypeId = flowTypeId)
                val response = service.createCategory(dto)

                if (response.isSuccessful && response.body()?.success == true) {
                    _category_State.value = categoryState.success
                    _categoryName.value = ""
                    loadCategories(context) // Recargar categorías después de crear una nueva
                } else {
                    _category_State.value = categoryState.error(response.body()?.message ?: "Error al crear categoría")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error de conexión: ${e.message}"
                _category_State.value = categoryState.error("Error al crear categoría: ${e.message}")
                Log.e("CategoriesViewModel", "createCategory: ${e.message}", e)
            }
        }
    }

    fun resetCategoryState() {
        _category_State.value = categoryState.idle
    }
}