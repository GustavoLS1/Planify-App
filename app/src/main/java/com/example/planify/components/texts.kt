package com.example.planify.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor

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
fun textWelcomePlanify() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = FourthColor)) {
                append("Bienvenido ")
            }
            withStyle(style = SpanStyle(color = Color.White)) {
                append(" a nuestro administrador de pagos.")
            }

        },
        fontFamily = letterStyles.AmaranthFont,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        textAlign = TextAlign.Center,

    )
}

@Composable
fun textSecondWelcomePlanify() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White)) {
                append("¿Estás listo para tomar el control de tus ")
            }
            withStyle(style = SpanStyle(color = FourthColor)) {
                append(" finanzas")
            }
            withStyle(style = SpanStyle(color = Color.White)) {
                append("?")
            }


        },
        fontFamily = letterStyles.AmaranthFont,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        textAlign = TextAlign.Center,

        )
}

@Composable
fun textNext() {
    Text(
        text = "Siguiente",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 32.sp),
        textAlign = TextAlign.Center
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
fun textforgetPassword() {
    Text(
        text = "¿Olvidó su correo electronico o contraseña?",
        color = FourthColor,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 15.sp)
    )
}

@Composable
fun textNombre() {
    Text(
        text = "Nombre completo:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun textConfirmPassword() {
    Text(
        text = "Confirmar contraseña:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
    )
}

@Composable
fun textNumber() {
    Text(
        text = "Número de celular:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
    )
}

@Composable
fun textDate() {
    Text(
        text = "Fecha de nacimiento:",
        color = Color.White,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
    )
}
