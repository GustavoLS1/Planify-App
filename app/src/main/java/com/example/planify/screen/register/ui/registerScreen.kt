package com.example.planify.screen.register.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.BouncingDotsAnimation
import com.example.planify.components.DatePicker
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.components.Email
import com.example.planify.components.Name
import com.example.planify.components.Password
import com.example.planify.components.Number
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonRegister2
import com.example.planify.components.configPassword
import com.example.planify.components.customDialog
import com.example.planify.components.roundedContainerScreen
import com.example.planify.components.textConfirmPassword
import com.example.planify.components.textDate
import com.example.planify.components.textEmail
import com.example.planify.components.textNombre
import com.example.planify.components.textNumber
import com.example.planify.components.textPassword
import com.example.planify.screen.login.ui.loginState
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun registerScreen(modifier: Modifier,
                   navigateToLogin: () -> Unit,
                   viewModel: registerViewModel = viewModel()) {

    val scrollState = rememberScrollState()
    val registerState by viewModel.register_State

    LaunchedEffect(registerState) {
        if (registerState is registerState.error) {
            delay(2000)
            viewModel.resetRegisterState()
        } else if (registerState is registerState.success){
            delay(2000)
            navigateToLogin()
            viewModel.resetRegisterState()
        }
    }

    backgroundScreen(modifier){
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            header()
            Spacer(modifier = Modifier.weight(1f))
            Body(registerViewModel = viewModel,
                modifier = Modifier)
        }
        when (registerState) {
            is registerState.loading -> {
                customDialog(
                    title = "Cargando",
                    subtitle = "Tu aventura está a punto de comenzar",
                    icon = { BouncingDotsAnimation() },
                    onDismiss = {}
                )
            }
            is registerState.success -> {
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
                    onDismiss = { viewModel.resetRegisterState() }
                )
            }
            is registerState.error -> {
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
                    onDismiss = { viewModel.resetRegisterState() }
                )
            }
            else -> Unit
        }
    }


}

@Composable
fun header() {

    Text(
        text = "Crear una cuenta",
        color = FourthColor,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 40.sp),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 65.dp)
    )

    Spacer(modifier = Modifier.size(57.dp))

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Body(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    registerViewModel: registerViewModel,
    modifier: Modifier
) {

    roundedContainerScreen(modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val email:String by registerViewModel.email
            val name:String by registerViewModel.name
            val password:String by registerViewModel.password
            val configPassword:String by registerViewModel.confirmPassword
            val number:String by registerViewModel.number
            val isRegisterEnabled:Boolean by registerViewModel.isRegisterEnabled
            // Grupo de Correo Electrónico y nombre
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textEmail()
                Spacer(modifier = Modifier.size(13.dp))
                Email(email) {
                    registerViewModel.onRegisterChange(
                        email = it,
                        password = password,
                        confirmPassword = configPassword,
                        name = name,
                        number = number
                    )
                }
                Spacer(modifier = Modifier.size(11.dp))
                textNombre()
                Spacer(modifier = Modifier.size(13.dp))
                Name(name) {
                    registerViewModel.onRegisterChange(
                        email = email,
                        password = password,
                        confirmPassword = configPassword,
                        name = it,
                        number = number
                    )
                }
            }

            Spacer(modifier = Modifier.size(11.dp))

            // Grupo de Contraseña y confirmar contraseña
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textPassword()
                Spacer(modifier = Modifier.size(13.dp))
                Password(password) {
                    registerViewModel.onRegisterChange(
                        email = email,
                        password = it,
                        confirmPassword = configPassword,
                        name = name,
                        number = number
                    )
                }
                Spacer(modifier = Modifier.size(13.dp))
                textConfirmPassword()
                Spacer(modifier = Modifier.size(13.dp))
                configPassword(configPassword) {
                    registerViewModel.onRegisterChange(
                        email = email,
                        password = password,
                        confirmPassword = it,
                        name = name,
                        number = number
                    )
                }
            }

            Spacer(modifier = Modifier.size(11.dp))

            // Grupo del numero de celular y fecha
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textDate()
                Spacer(modifier = Modifier.size(13.dp))
                DatePicker()
                Spacer(modifier = Modifier.size(13.dp))
                textNumber()
                Spacer(modifier = Modifier.size(13.dp))
                Number(number){
                    registerViewModel.onRegisterChange(
                        email = email,
                        password = password,
                        confirmPassword = configPassword,
                        name = name,
                        number = it
                    )
                }

            }

            Spacer(modifier = Modifier.size(51.dp))
            buttonRegister2(enabled = isRegisterEnabled) {
                registerViewModel.register()
            } // Como el componente de navegación no está implementado, se deja un println para indicar que la pantalla está pendiente
              // Ademas se recomienda cambiar navigateToRegister por navigateTo ya que es mas general y poderla usar en otros Screens
            Spacer(modifier = Modifier.size(51.dp))
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun previewRegisterScreen(){
//    registerScreen(modifier = Modifier, function = {
//        navController.navigate(welcomePlanifyScreen)
//    })
//}