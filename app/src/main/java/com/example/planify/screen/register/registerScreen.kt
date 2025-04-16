package com.example.planify.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.planify.ui.theme.PrimaryColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.components.DatePicker
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.ThirdColor
import com.example.planify.components.Email
import com.example.planify.components.Name
import com.example.planify.components.Password
import com.example.planify.components.Number
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonRegister
import com.example.planify.components.buttonRegister2
import com.example.planify.components.configPassword
import com.example.planify.components.roundedContainerScreen
import com.example.planify.components.textConfirmPassword
import com.example.planify.components.textDate
import com.example.planify.components.textEmail
import com.example.planify.components.textNombre
import com.example.planify.components.textNumber
import com.example.planify.components.textPassword

@Composable
fun registerScreen(modifier: Modifier) {

    val scrollState = rememberScrollState()

    backgroundScreen{
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            header()
            Spacer(modifier = Modifier.weight(1f))
            Body()
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

@Composable
fun Body(onLoginClick: (String, String) -> Unit = { _, _ -> }) {

    roundedContainerScreen{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var email by rememberSaveable { mutableStateOf("") }
            var name by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var configPassword by rememberSaveable { mutableStateOf("") }
            var number by rememberSaveable { mutableStateOf("") }
            var isLoginEnabled by rememberSaveable { mutableStateOf(false) }
            // Grupo de Correo Electrónico y nombre
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textEmail()
                Spacer(modifier = Modifier.size(13.dp))
                Email(email) {
                    email = it
                }
                Spacer(modifier = Modifier.size(11.dp))
                textNombre()
                Spacer(modifier = Modifier.size(13.dp))
                Name(name) {
                    name = it
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
                    password = it
                }
                Spacer(modifier = Modifier.size(13.dp))
                textConfirmPassword()
                Spacer(modifier = Modifier.size(13.dp))
                configPassword(configPassword) {
                    configPassword = it
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
                    number = it
                }

            }

            Spacer(modifier = Modifier.size(51.dp))
            buttonRegister2(navigateTo = {
                println("Pantalla pendiente")
            }) // Como el componente de navegación no está implementado, se deja un println para indicar que la pantalla está pendiente
              // Ademas se recomienda cambiar navigateToRegister por navigateTo ya que es mas general y poderla usar en otros Screens
            Spacer(modifier = Modifier.size(51.dp))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun previewRegisterScreen(){
    registerScreen(modifier = Modifier)
}