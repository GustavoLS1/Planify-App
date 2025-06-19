package com.example.planify.screen.categories.ui

import com.example.planify.screen.categories.ui.data.response.categoryDto
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class CategoriesViewModelTest {

    private lateinit var viewModel: categoriesViewModel

    @Before
    fun setup() {
        viewModel = categoriesViewModel()
    }

    @Test
    fun getIncomeCategories() {
        val mockData = listOf(categoryDto(1, "Salario", 2, "INGRESOS", 1, false))
        viewModel.setCategoryType("INGRESOS")
        viewModel.loadCategoriesMock(mockData)
        assertEquals(1, viewModel.incomeCategories.value.size)
    }

    @Test
    fun getExpenseCategories() {
        val mockData = listOf(categoryDto(2, "Renta", 1, "GASTOS", 1, false))
        viewModel.setCategoryType("GASTOS")
        viewModel.loadCategoriesMock(mockData)
        assertEquals(1, viewModel.expenseCategories.value.size)
    }

    @Test
    fun getCategoryName() {
        viewModel.onCategoryNameChange("Test")
        assertEquals("Test", viewModel.categoryName.value)
    }

    @Test
    fun isSaveEnabled() {
        viewModel.onCategoryNameChange("Test")
        assertTrue(viewModel.isSaveEnabled.value)
    }

    @Test
    fun getSelectedType() {
        viewModel.setCategoryType("GASTOS")
        assertEquals("GASTOS", viewModel.selectedType.value)
    }

    @Test
    fun getSearchQuery() {
        viewModel.onQueryChanged("food")
        assertEquals("food", viewModel.searchQuery.value)
    }

    @Test
    fun getErrorMessage() {
        // Dado que no usamos red, probamos que por defecto sea null
        assertNull(viewModel.errorMessage.value)
    }

    @Test
    fun getCategory_State() {
        viewModel.resetCategoryState()
        assertEquals(categoryState.idle, viewModel.category_State.value)
    }

    @Test
    fun getDisplayedCategories() {
        val mockData = listOf(
            categoryDto(1, "Salario", 2, "INGRESOS", 1, false),
            categoryDto(2, "Regalo", 2, "INGRESOS", 1, false),
            categoryDto(3, "Renta", 1, "GASTOS", 1, false)
        )
        viewModel.setCategoryType("INGRESOS")
        viewModel.onQueryChanged("Sal")
        viewModel.loadCategoriesMock(mockData)
        assertEquals(1, viewModel.displayedCategories.value.size)
        assertEquals("Salario", viewModel.displayedCategories.value.first().name)
    }

    // Helper para inyectar categorías sin llamada real a Retrofit
    private fun categoriesViewModel.loadCategoriesMock(mockList: List<categoryDto>) {
        val income = mockList.filter { it.flowTypeName.uppercase() == "INGRESOS" }
        val expense = mockList.filter { it.flowTypeName.uppercase() == "GASTOS" }
        val incomeField = categoriesViewModel::class.java.getDeclaredField("_incomeCategories")
        val expenseField = categoriesViewModel::class.java.getDeclaredField("_expenseCategories")
        incomeField.isAccessible = true
        expenseField.isAccessible = true
        incomeField.set(this, androidx.compose.runtime.mutableStateOf(income))
        expenseField.set(this, androidx.compose.runtime.mutableStateOf(expense))
    }
}