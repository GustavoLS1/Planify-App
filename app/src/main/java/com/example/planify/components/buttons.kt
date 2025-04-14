package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.R
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor

@Composable
fun buttonLogin(){
    Button(
        onClick = {"Click"},
        modifier = Modifier
            .fillMaxWidth(0.55f)
            .height(45.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(FourthColor)
    ) {
        Text(
            text = "Iniciar Sesión",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = PrimaryColor,
            fontSize = 20.sp,
            fontFamily = letterStyles.AmaranthFont
        )
    }
}

@Composable
fun RadioButtonGroup() {
    val selectedOption = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .background(Color(0xFF1A1A55)) // Fondo como en la imagen
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        RadioButton(
            selected = selectedOption.value,
            onClick = { selectedOption.value = true },
            modifier = Modifier.scale(1.5f),
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFB1AFE5),
                unselectedColor = Color(0xFFB1AFE5),
                disabledSelectedColor = Color.Gray
            )
        )
        RadioButton(
            selected = !selectedOption.value,
            onClick = { selectedOption.value = false },
            modifier = Modifier.scale(1.5f),
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFB1AFE5),
                unselectedColor = Color(0xFFB1AFE5),
                disabledSelectedColor = Color.Gray
            )
        )
    }
}



@Composable
fun buttonLoginEnable(loginEnabled: Boolean){
    Button(
        onClick = {"Click"},
        enabled = loginEnabled,
        modifier = Modifier
            .fillMaxWidth(0.55f)
            .height(45.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(FourthColor)
    ) {
        Text(
            text = "Iniciar Sesión",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = PrimaryColor,
            fontSize = 20.sp,
            fontFamily = letterStyles.AmaranthFont
        )
    }
}
@Composable
fun buttonRegister(){
    Button(
        onClick = {"Click"},
        modifier = Modifier
            .fillMaxWidth(0.55f)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(SecondColor),
    ) {
        Text(
            text = "Registrarse",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = letterStyles.AmaranthFont,
        )
    }
}
// Se agrega la navigateToRegister como una funcion lambda para que se pueda realizar la navegacion con el login
// Ademas se recomienda cambiar navigateToRegister por navigateTo ya que es mas general y poderla usar en otros Screens
// Para evitar confuciones
@Composable
fun buttonRegister2(navigateToRegister: () -> Unit ) {
    Button(
        onClick = {navigateToRegister()},
        modifier = Modifier
            .fillMaxWidth(0.55f)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(FourthColor),
    ) {
        Text(
            text = "Registrarse",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = PrimaryColor,
            fontSize = 20.sp,
            fontFamily = letterStyles.AmaranthFont,
        )
    }
}

@Composable
fun buttonLoginGoogle(){
    Button(
        onClick = {"Click"},
        modifier = Modifier
            .fillMaxWidth(0.55f)
            .height(45.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_googleg_48dp),
                contentDescription = "Google Icon",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Iniciar sesión Google",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().weight(1f),
                color = PrimaryColor,
                fontSize = 16.sp,
                fontFamily = letterStyles.AmaranthFont,
                maxLines = 2,
                softWrap = true,
            )

        }
    }
}