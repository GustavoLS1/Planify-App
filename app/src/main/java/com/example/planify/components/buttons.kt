package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun buttonRegister2(){
    Button(
        onClick = {"Click"},
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