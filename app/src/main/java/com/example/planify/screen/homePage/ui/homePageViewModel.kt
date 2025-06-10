package com.example.planify.screen.homePage.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.homePage.ui.data.response.transactionCreateResponseDto
import com.example.planify.screen.homePage.ui.di.homePageRetrofitHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class homePageViewModel: ViewModel() {

    private val _income = mutableStateOf(0.0)
    val income: State<Double> = _income

    private val _expense = mutableStateOf(0.0)
    val expense: State<Double> = _expense

    private  val _totalbalance = derivedStateOf {_income.value - _expense.value}
    val totalbalance: State<Double> = _totalbalance

    private val _movements = mutableStateOf<List<movements>>(emptyList())
    val movements: State<List<movements>> = _movements

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _transactionState = mutableStateOf<homePageState>(homePageState.idle)
    val transactionState: State<homePageState> = _transactionState

    init {
        loadData()
    }

    private fun loadData() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                delay(1000) // Simula una carga de datos desde una fuente remota o local

                // Reemplaza estas líneas con datos reales desde repositorio

                val SimulatedData = listOf(//Datos simulados que luego se reemplazarán por datos reales
                    movements(1, "Salario", 1500.0, typeMovements.INCOME),
                    movements(2, "Alquiler", 500.0, typeMovements.EXPENSE),
                    movements(3, "Venta", 300.0, typeMovements.INCOME),
                    movements(4, "Transporte", 120.0, typeMovements.EXPENSE),
                    movements(5, "Comida", 200.0, typeMovements.EXPENSE),
                    movements(6, "Cine", 100.0, typeMovements.EXPENSE),
                    movements(7, "Freelance", 400.0, typeMovements.INCOME),
                    movements(8, "Suscripción", 50.0, typeMovements.EXPENSE),
                    movements(9, "Regalo", 80.0, typeMovements.EXPENSE),
                    movements(10, "Ahorros", 600.0, typeMovements.INCOME),
                    movements(11, "Internet", 60.0, typeMovements.EXPENSE),
                    movements(12, "Electricidad", 90.0, typeMovements.EXPENSE),
                    movements(13, "Agua", 40.0, typeMovements.EXPENSE),
                    movements(14, "Gas", 70.0, typeMovements.EXPENSE),
                    movements(16, "Seguro", 200.0, typeMovements.EXPENSE),
                    movements(17, "Impuestos", 300.0, typeMovements.EXPENSE),
                    movements(18, "Donación", 100.0, typeMovements.EXPENSE),
                )
                _movements.value = SimulatedData

                _income.value = SimulatedData.filter { it.type == typeMovements.INCOME }.sumOf { it.amount }
                _expense.value = SimulatedData.filter { it.type == typeMovements.EXPENSE }.sumOf { it.amount }
                _errorMessage.value = null

            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar datos"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Si necesitas actualizar desde UI (como un "swipe to refresh"):
    fun reloadData() {
        loadData()
    }
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    val filteredMovements: State<List<movements>> = derivedStateOf {
        val query = _searchQuery.value.trim().lowercase()
        if (query.isBlank()) {
            _movements.value
        } else {
            _movements.value.filter {
                it.title.lowercase().contains(query)
            }
        }
    }

    // Si planeas agregar ingresos/gastos desde pop-ups:
    fun addIncome(monto: Double) {
        if (monto > 0) {
            _income.value += monto
        }
    }

    fun addExpense(monto: Double) {
        if (monto > 0) {
            _expense.value += monto
        }
    }

    fun createTransaction(dto: transactionCreateResponseDto, context: Context) {
        viewModelScope.launch {
            _transactionState.value = homePageState.loading
            try {
                val service = homePageRetrofitHelper.getHomePageService(context)
                val response = service.transactionCreate(dto)

                if (response.isSuccessful && response.body()?.success == true) {
                    _transactionState.value = homePageState.success
                    reloadData() // Para reflejar los cambios
                } else {
                    _transactionState.value = homePageState.error(response.body()?.message ?: "Error en la creación")
                }
            } catch (e: Exception) {
                _transactionState.value = homePageState.error("Error de conexión")
                Log.e("HomePage", "createTransaction: ${e.message}", e)
            }
        }
    }

    fun resetTransactionState() {
        _transactionState.value = homePageState.idle
    }

}
