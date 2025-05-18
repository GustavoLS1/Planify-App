package com.example.planify.screen.forgetPassword.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.BouncingDotsAnimation
import com.example.planify.components.Code
import com.example.planify.components.Email
import com.example.planify.components.Password
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonNextEnabled
import com.example.planify.components.configPassword
import com.example.planify.components.customDialog
import com.example.planify.components.roundedContainerLaunchScreen
import com.example.planify.components.textConfirmPassword
import com.example.planify.components.textDetailAccountForgetPassword
import com.example.planify.components.textEmailOrNumPhoneForgetPassword
import com.example.planify.components.textForgetNewPassword
import com.example.planify.components.textForgetPassword
import com.example.planify.components.textLinkResetForgetPassword
import com.example.planify.components.textNewPassword
import kotlinx.coroutines.delay


@Composable
fun forgetPasswordScreen(
    modifier: Modifier,
    navigateToLogin: () -> Unit = {},
    viewModel: forgetPasswordViewModel = viewModel()
) {
    val currentStep by viewModel.currentStep
    val email by viewModel.email
    val password by viewModel.password
    val code by viewModel.code
    val configPassword by viewModel.confirmPassword
    val isforgetPasswordEnabled by viewModel.isforgetPasswordEnabled
    val forgetPasswordState by viewModel.forgetPassword_State

    // Manejamos efectos colaterales como mostrar mensaje por error y resetear el estado
    LaunchedEffect(forgetPasswordState) {
        if (forgetPasswordState is forgetPasswordState.error || forgetPasswordState is forgetPasswordState.success) {
            delay(2000)
            viewModel.resetForgetPasswordState()
        }
    }

    backgroundScreen(modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(50.dp))
            textForgetPassword()
            Spacer(modifier = Modifier.size(50.dp))
            roundedContainerLaunchScreen(modifier = Modifier) {
                when (currentStep) {
                    1 -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxWidth(0.8f),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    textDetailAccountForgetPassword()
                                    Spacer(modifier = Modifier.size(43.dp))
                                    textEmailOrNumPhoneForgetPassword()
                                    Spacer(modifier = Modifier.size(17.dp))
                                    Email(email) {
                                        viewModel.onforgetPasswordChange(
                                            email = it,
                                            password = password,
                                            confirmPassword = configPassword,
                                            code = code
                                        )
                                    }
                                    Spacer(modifier = Modifier.size(254.dp))
                                }
                                buttonNextEnabled(isforgetPasswordEnabled) {
                                    viewModel.requestReset()
                                    viewModel.goToStep(2)
                                }
                            }
                        }
                    }

                    2 -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxWidth(0.8f),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    textDetailAccountForgetPassword()
                                    Spacer(modifier = Modifier.size(28.dp))
                                    textLinkResetForgetPassword()
                                    Spacer(modifier = Modifier.size(27.dp))
                                    Code(code) {
                                        viewModel.onforgetPasswordChange(
                                            email = email,
                                            password = password,
                                            confirmPassword = configPassword,
                                            code = it
                                        )
                                    }
                                    Spacer(modifier = Modifier.size(244.dp))
                                }
                                buttonNextEnabled(isforgetPasswordEnabled) {
                                    viewModel.verifyCode()
                                    viewModel.goToStep(3)
                                }
                            }

                        }
                    }

                    3 -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxWidth(0.8f),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    textForgetNewPassword()
                                    Spacer(modifier = Modifier.size(41.dp))
                                    textNewPassword()
                                    Spacer(modifier = Modifier.size(9.dp))
                                    Password(password) {
                                        viewModel.onforgetPasswordChange(
                                            email = email,
                                            password = it,
                                            confirmPassword = configPassword,
                                            code = code
                                        )
                                    }
                                    Spacer(modifier = Modifier.size(38.dp))
                                    textConfirmPassword()
                                    Spacer(modifier = Modifier.size(9.dp))
                                    configPassword(configPassword) {
                                        viewModel.onforgetPasswordChange(
                                            email = email,
                                            password = password,
                                            confirmPassword = it,
                                            code = code
                                        )
                                    }
                                    Spacer(modifier = Modifier.size(152.dp))
                                }
                                buttonNextEnabled(isforgetPasswordEnabled) {
                                    viewModel.resetPassword()
                                    navigateToLogin()
                                }
                            }
                        }
                    }
                }
            }
        }

        // Mostrar diálogos según el estado
        when (forgetPasswordState) {
            is forgetPasswordState.loading -> {
                customDialog(
                    title = "Cargando",
                    subtitle = "Procesando tu solicitud...",
                    icon = { BouncingDotsAnimation() },
                    onDismiss = {}
                )
            }

            is forgetPasswordState.success -> {
                customDialog(
                    title = "Éxito",
                    subtitle = "La operación fue exitosa",
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.success),
                            contentDescription = "success",
                            modifier = Modifier.size(95.dp)
                        )
                    },
                    onDismiss = { viewModel.resetForgetPasswordState() }
                )
            }

            is forgetPasswordState.error -> {
                customDialog(
                    title = "Error",
                    subtitle = (forgetPasswordState as forgetPasswordState.error).message,
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.fail),
                            contentDescription = "error",
                            modifier = Modifier.size(95.dp)
                        )
                    },
                    onDismiss = { viewModel.resetForgetPasswordState() }
                )
            }

            else -> Unit
        }
    }
}



@Preview
@Composable
fun previewForgetPasswordScreen(){
    forgetPasswordScreen(modifier = Modifier,
        navigateToLogin = {},
    )
}