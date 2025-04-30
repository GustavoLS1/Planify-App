package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.R
import com.example.planify.letterStyles
import com.example.planify.ui.theme.ThirdColor

@Composable
fun fail() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.5f)),// fondo transparente oscuro
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .background(ThirdColor, shape = RoundedCornerShape(30.dp))
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fail),
                contentDescription = "fail",
                modifier = Modifier.size(95.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Credenciales incorrectas",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp, fontFamily = letterStyles.AmaranthFont)
            )
        }
    }
}