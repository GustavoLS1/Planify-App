package com.example.planify.screen.forgetPassword.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.planify.screen.forgetPassword.ui.data.response.RequestResetDto
import com.example.planify.screen.forgetPassword.ui.data.response.ResetPasswordDto
import com.example.planify.screen.forgetPassword.ui.data.response.VerifyCodeDto
import com.example.planify.screen.forgetPassword.ui.di.forgetPasswordRetrofitHelper
import kotlinx.coroutines.launch

class forgetPasswordViewModel: ViewModel() {
    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmPassword = mutableStateOf("")
    val confirmPassword: State<String> = _confirmPassword

    private val _code = mutableStateOf("")
    val code: State<String> = _code

    private val _currentStep = mutableStateOf(1)
    val currentStep: State<Int> = _currentStep

    private val _uiState = mutableStateOf<forgetPasswordState>(forgetPasswordState.idle)
    val uiState: State<forgetPasswordState> = _uiState

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isforgetPasswordEnabled = mutableStateOf(false)
    val isforgetPasswordEnabled: State<Boolean> = _isforgetPasswordEnabled

    fun onforgetPasswordChange(
        email: String,
        code: String,
        password: String,
        confirmPassword: String
    ) {
        _email.value = email.take(50) // Limita un maximo de 50 caracteres
        _password.value = password.take(8) // Limita un maximo de 8 caracteres
        _confirmPassword.value = confirmPassword.take(8) // Limita un maximo de 8 caracteres
        _code.value = code.take(6) // Limita un maximo de 6 caracteres
        _isforgetPasswordEnabled.value = enableforgetPasswordButton(
            step = _currentStep.value,
            email = _email.value,
            code = _code.value,
            password = _password.value,
            confirmPassword = _confirmPassword.value)
    }


    fun goToStep(step: Int) {
        _currentStep.value = step
    }

    fun enableforgetPasswordButton(step: Int,email: String,code: String, password: String, confirmPassword: String): Boolean{
        return when(step){
            1 -> android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            2 -> code.length == 6
            3 -> password.isNotBlank() && password == confirmPassword
            else -> false
        }
    }

    fun requestReset(){
        viewModelScope.launch {
            _uiState.value = forgetPasswordState.loading
            try {
                val service = forgetPasswordRetrofitHelper.getForgetPasswordService()
                val response = service.requestReset(RequestResetDto(email = _email.value))

                if (response.isSuccessful){
                    _uiState.value = forgetPasswordState.success
                }else{
                    _uiState.value = forgetPasswordState.error("No se pudo enviar el código")
                }
            } catch (e: Exception){
                _uiState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "requestReset: ${e.message}", e)
            }
        }
    }

    fun verifyCode(){
        viewModelScope.launch {
            _uiState.value = forgetPasswordState.loading
            try {
                val service = forgetPasswordRetrofitHelper.getForgetPasswordService()
                val response = service.verifyCode(VerifyCodeDto(email = _email.value, code= _code.value))

                if (response.isSuccessful){
                    _uiState.value = forgetPasswordState.success
                } else{
                    _uiState.value = forgetPasswordState.error("Código inválido")
                }
            }catch (e: Exception){
                _uiState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "verifyCode: ${e.message}", e)
            }
        }
    }

    fun resetPassword(){
        viewModelScope.launch {
            _uiState.value = forgetPasswordState.loading
            try {
                val service = forgetPasswordRetrofitHelper.getForgetPasswordService()
                val response = service.resetPassword(
                    ResetPasswordDto(
                        email = _email.value,
                        code = _code.value,
                        newPassword = _password.value
                    )
                )

                if (response.isSuccessful){
                    _uiState.value = forgetPasswordState.success
                } else{
                    _uiState.value = forgetPasswordState.error("No se pudo restablecer la contraseña")
                }
            }catch (e: Exception){
                _uiState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "resetPassword: ${e.message}", e)
            }
        }
    }
}