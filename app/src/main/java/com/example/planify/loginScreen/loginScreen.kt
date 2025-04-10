package com.example.planify.loginScreen

import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.ThirdColor
import com.example.planify.components.Email
import com.example.planify.components.Password
import com.example.planify.components.buttonLoginEnable
import com.example.planify.components.buttonRegister2
import com.example.planify.components.textEmail
import com.example.planify.components.textPassword
import com.example.planify.components.textforgetPassword

@Composable
fun loginScreen(modifier: Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
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
        text = "Iniciar Sesión",
        color = FourthColor,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 40.sp),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 65.dp)
    )

}

@Composable
fun Body(onLoginClick: (String, String) -> Unit = { _, _ -> }) {
    Box(
        modifier = Modifier
            .size(412.dp, 700.dp) //Otra forma de destacar el ancho y el alto
            .padding()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(ThirdColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var isLoginEnabled by rememberSaveable { mutableStateOf(false) }
            // Grupo de Correo Electrónico
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textEmail()
                Spacer(modifier = Modifier.size(8.dp))
                Email(email) {
                    email = it
                    isLoginEnabled = enableLoginButton(email,password)
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
                    password = it
                    isLoginEnabled = enableLoginButton(email,password)
                }
            }

            Spacer(modifier = Modifier.size(90.dp))
            buttonLoginEnable(isLoginEnabled)
            Spacer(modifier = Modifier.size(28.dp))
            buttonRegister2()
            Spacer(modifier = Modifier.size(28.dp))
            textforgetPassword()
        }

    }
}

fun enableLoginButton(email:String, password:String) =
    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6




@Preview(showBackground = true)
@Composable
fun PreviewloginView() {
    loginScreen(modifier = Modifier)
}