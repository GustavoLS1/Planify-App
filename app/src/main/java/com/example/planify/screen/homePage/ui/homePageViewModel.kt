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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class homePageViewModel : ViewModel() {

    private val _income = mutableStateOf(0.0)
    val income: State<Double> = _income

    private val _expense = mutableStateOf(0.0)
    val expense: State<Double> = _expense

    private val _totalbalance = derivedStateOf { _income.value - _expense.value }
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


    fun loadData(context: Context, fecha: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val service = homePageRetrofitHelper.getHomePageService(context = context)
                val response = service.getTransaction(fecha)

                if (response.isSuccessful && response.body()?.success == true) {
                    val transactions = response.body()?.response ?: emptyList()

                    val backendmovements = transactions.map {
                        movements(
                            title = it.description,
                            amount = it.amount,
                            type = when (it.category.flowTypeName.uppercase()) {
                                "INGRESOS" -> typeMovements.INCOME
                                "GASTOS" -> typeMovements.EXPENSE
                                else -> throw IllegalArgumentException("Tipo de movimiento desconocido")
                            }
                        )
                    }

                    _movements.value = backendmovements
                    _income.value = backendmovements.filter { it.type == typeMovements.INCOME }.sumOf { it.amount }
                    _expense.value = backendmovements.filter { it.type == typeMovements.EXPENSE }.sumOf { it.amount }
                    _errorMessage.value = null // Limpiar mensaje de error si la carga fue exitosa
                }else{
                    _errorMessage.value = response.body()?.message ?: "Error al cargar datos"
                }

            } catch (e: Exception) {
                _errorMessage.value = "Error de conexión: ${e.message}"
                Log.e("HomePage", "loadData: ${e.message}", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

        // Si necesitas actualizar desde UI (como un "swipe to refresh"):
        fun reloadData(context: Context, fecha: String) {
            loadData(context, fecha)
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
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    val fechaActual = LocalDate.now().format(formatter)

                    if (response.isSuccessful && response.body()?.success == true) {
                        _transactionState.value = homePageState.success
                        reloadData(context, fechaActual) // Para reflejar los cambios
                    } else {
                        _transactionState.value =
                            homePageState.error(response.body()?.message ?: "Error en la creación")
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
