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

    private val _forgetPasswordState = mutableStateOf<forgetPasswordState>(forgetPasswordState.idle)
    val forgetPassword_State: State<forgetPasswordState> = _forgetPasswordState

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _isforgetPasswordEnabled = mutableStateOf(false)
    val isforgetPasswordEnabled: State<Boolean> = _isforgetPasswordEnabled

    fun onforgetPasswordChange(
        email: String = _email.value,
        code: String = _code.value,
        password: String = _password.value,
        confirmPassword: String = _confirmPassword.value
    ) {
        _email.value = email.take(50)
        _code.value = code.take(6)
        _password.value = password.take(15)
        _confirmPassword.value = confirmPassword.take(15)
        validateFields()
    }

    fun resetForgetPasswordState() {
        _forgetPasswordState.value = forgetPasswordState.idle
    }


    fun goToStep(step: Int) {
        _currentStep.value = step
        validateFields()
    }

    private fun validateFields() {
        _isforgetPasswordEnabled.value = when (_currentStep.value) {
            1 -> android.util.Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()
            2 -> _code.value.length == 6
            3 -> _password.value.isNotBlank() && _password.value == _confirmPassword.value
            else -> false
        }
    }

    fun requestReset(){
        viewModelScope.launch {
            _forgetPasswordState.value = forgetPasswordState.loading
            try {
                val service = forgetPasswordRetrofitHelper.getForgetPasswordService()
                val response = service.requestReset(RequestResetDto(email = _email.value))

                if (response.isSuccessful){
                    _forgetPasswordState.value = forgetPasswordState.success
                }else{
                    _forgetPasswordState.value = forgetPasswordState.error("No se pudo enviar el código")
                }
            } catch (e: Exception){
                _forgetPasswordState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "requestReset: ${e.message}", e)
            }
        }
    }

    fun verifyCode(){
        viewModelScope.launch {
            _forgetPasswordState.value = forgetPasswordState.loading
            try {
                val service = forgetPasswordRetrofitHelper.getForgetPasswordService()
                val response = service.verifyCode(VerifyCodeDto(email = _email.value, code= _code.value))

                if (response.isSuccessful){
                    _forgetPasswordState.value = forgetPasswordState.success
                } else{
                    _forgetPasswordState.value = forgetPasswordState.error("Código inválido")
                }
            }catch (e: Exception){
                _forgetPasswordState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "verifyCode: ${e.message}", e)
            }
        }
    }

    fun resetPassword(){
        viewModelScope.launch {
            _forgetPasswordState.value = forgetPasswordState.loading
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
                    _forgetPasswordState.value = forgetPasswordState.success
                } else{
                    _forgetPasswordState.value = forgetPasswordState.error("No se pudo restablecer la contraseña")
                }
            }catch (e: Exception){
                _forgetPasswordState.value = forgetPasswordState.error("Error de conexión")
                Log.e("ForgetPassword", "resetPassword: ${e.message}", e)
            }
        }
    }
}