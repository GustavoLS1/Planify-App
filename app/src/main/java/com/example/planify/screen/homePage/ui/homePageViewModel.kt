package com.example.planify.screen.homePage.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class homePageViewModel: ViewModel() {

    private val _ingresos = mutableStateOf(0.0)
    val ingresos: State<Double> = _ingresos

    private val _gastos = mutableStateOf(0.0)
    val gastos: State<Double> = _gastos

    private  val _saldoTotal = derivedStateOf {_ingresos.value - _gastos.value}
    val saldoTotal: State<Double> = _saldoTotal

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                delay(1000) // Simula una carga de datos desde una fuente remota o local

                // Reemplaza estas líneas con datos reales desde repositorio
                val ingresosSimulados = 2000.0
                val gastosSimulados = 750.0

                _ingresos.value = ingresosSimulados
                _gastos.value = gastosSimulados
                _errorMessage.value = null

            } catch (e: Exception) {
                _errorMessage.value = "Error al cargar datos"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Si necesitas actualizar desde UI (como un "swipe to refresh"):
    fun recargarDatos() {
        cargarDatos()
    }

    // Si planeas agregar ingresos/gastos desde pop-ups:
    fun agregarIngreso(monto: Double) {
        if (monto > 0) {
            _ingresos.value += monto
        }
    }

    fun agregarGasto(monto: Double) {
        if (monto > 0) {
            _gastos.value += monto
        }
    }

}
