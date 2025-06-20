package com.example.planify.screen.login.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.BouncingDotsAnimation
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.components.Email
import com.example.planify.components.Password
import com.example.planify.components.backgroundLaunchScreen
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonLoginEnable
import com.example.planify.components.buttonRegister
import com.example.planify.components.customDialog
import com.example.planify.components.roundedContainerLaunchScreen
import com.example.planify.components.textEmail
import com.example.planify.components.textPassword
import com.example.planify.components.textforgetPassword
import kotlinx.coroutines.delay

// Agregar navegateToRegister para habilitar la navegación a la screen de registro
@Composable
fun loginScreen(modifier: Modifier,
                navegateToRegister: () -> Unit,
                navegateToForgetPassword: () -> Unit,
                navegateToHome: () -> Unit,
                viewModel : loginViewModel = viewModel()) {

    val loginState by viewModel.login_State

    LaunchedEffect(loginState) {
        when (loginState) {
            is loginState.success -> {
                delay(1500) // opcional, para mostrar el diálogo un momento
                viewModel.resetLoginState()
                navegateToHome() //NAVEGAR AL HOME
            }
            is loginState.error -> {
                delay(2000)
                viewModel.resetLoginState()
            }
            else -> Unit
        }
    }

    backgroundLaunchScreen(modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            header()
            Spacer(modifier = Modifier.weight(1f))
            Body(
                onRegisterClick = navegateToRegister,
                navegateToForgetPassword = navegateToForgetPassword,
                loginViewModel = viewModel,
                modifier = Modifier
            )
        }

        when (loginState) {
            is loginState.loading -> {
                customDialog(
                    title = "Cargando",
                    subtitle = "Tu aventura está a punto de comenzar",
                    icon = { BouncingDotsAnimation() },
                    onDismiss = {}
                )
            }
            is loginState.success -> {
                customDialog(
                    title = "Satisfactorio",
                    subtitle = "",
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.success),
                            contentDescription = "success",
                            modifier = Modifier.size(95.dp)
                        )
                    },
                    onDismiss = { viewModel.resetLoginState() }
                )
            }
            is loginState.error -> {
                customDialog(
                    title = "Credenciales incorrectas",
                    subtitle = "",
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.fail),
                            contentDescription = "error",
                            modifier = Modifier.size(95.dp)
                        )
                    },
                    onDismiss = { viewModel.resetLoginState() }
                )
            }
            else -> Unit
        }
    }
}


@Composable
fun header() {

    Text(
        text = "Iniciar Sesión",
        color = FourthColor,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 40.sp),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 65.dp)
    )
    Spacer(modifier = Modifier.size(57.dp))
}

//Añadir onRegisterClick para habilitar la navegación a la screen de registro
@Composable
fun Body(onLoginClick: (String, String) -> Unit = { _, _ -> },
         modifier: Modifier,
         onRegisterClick: () -> Unit,
         navegateToForgetPassword: () -> Unit,
         loginViewModel: loginViewModel) {
    roundedContainerLaunchScreen(modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top=50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val email:String by loginViewModel.email
            val password:String by loginViewModel.password
            val isLoginEnabled:Boolean by loginViewModel.isLoginEnabled
            val context = LocalContext.current // Obtener el contexto actual
            // Grupo de Correo Electrónico
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textEmail()
                Spacer(modifier = Modifier.size(8.dp))
                Email(email) {
                    loginViewModel.onLoginChange(email = it, password = password)
                }
            }

            Spacer(modifier = Modifier.size(55.dp))

            // Grupo de Contraseña
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textPassword()
                Spacer(modifier = Modifier.size(8.dp))
                Password(password) {
                    loginViewModel.onLoginChange(password = it, email =  email)
                }
            }

            Spacer(modifier = Modifier.size(90.dp))
            buttonLoginEnable(isLoginEnabled){
                loginViewModel.login(context = context) // Se pasa el contexto actual
            }
            Spacer(modifier = Modifier.size(28.dp))
            buttonRegister(navigateTo = onRegisterClick)// Se pasa la función de navegación como parámetro
            Spacer(modifier = Modifier.size(28.dp))
            textforgetPassword(navigateToForgetPasswordScreen = navegateToForgetPassword)
        }

    }
}

