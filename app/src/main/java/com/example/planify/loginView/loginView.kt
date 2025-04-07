package com.example.planify.loginView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.planify.ui.theme.PrimaryColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.ThirdColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun loginView(modifier: Modifier) {

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
fun Body() {
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
            // Grupo de Correo Electrónico
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textEmail()
                Spacer(modifier = Modifier.size(8.dp))
                Email(email) { email = it }
            }

            Spacer(modifier = Modifier.size(55.dp))

            // Grupo de Contraseña
            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                textPassword()
                Spacer(modifier = Modifier.size(8.dp))
                Password(password) { password = it }
            }

            Spacer(modifier = Modifier.size(90.dp))
            buttonLogin()
            Spacer(modifier = Modifier.size(28.dp))
            buttonRegister()
            Spacer(modifier = Modifier.size(28.dp))
            forgetPassword()
        }

    }
}


@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black), // Texto negro para mejor visibilidad
        placeholder = {Text(text = "Email")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        )
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(min = 45.dp)
            .clip(RoundedCornerShape(10.dp)),
        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
        placeholder = {Text(text = "Contraseña")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            val imagen = if (passordVisibility){
                Icons.Filled.VisibilityOff
            }else{
                Icons.Filled.Visibility
            }
            IconButton(onClick = {passordVisibility =! passordVisibility}) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        },
        visualTransformation = if (passordVisibility){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun textEmail() {
    Text(
        text = "Correo electrónico:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun textPassword() {
    Text(
        text = "Contraseña:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
    )
}

@Composable
fun buttonLogin() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { "Click" },
            modifier = Modifier
                .width(207.dp)
                .height(45.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(FourthColor),
            shape = RoundedCornerShape(10.dp),
        ) {

            Text(
                text = "Iniciar Sesíon",
                color = PrimaryColor,
                style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)

            )
        }
    }

}

@Composable
fun buttonRegister() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { "Click" },
            modifier = Modifier
                .width(207.dp)
                .height(45.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(FourthColor),
            shape = RoundedCornerShape(10.dp),
        ) {

            Text(
                text = "Registrarse",
                color = PrimaryColor,
                style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)

            )
        }
    }

}

@Composable
fun forgetPassword() {
    Text(
        text = "¿Olvidó su correo electronico o contraseña?",
        color = FourthColor,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 15.sp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewloginView() {
    loginView(modifier = Modifier)
}