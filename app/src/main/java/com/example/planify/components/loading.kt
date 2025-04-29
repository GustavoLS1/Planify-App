package com.example.planify.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.ThirdColor
import kotlinx.coroutines.delay

@Composable
fun loading() {
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
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BouncingDotsAnimation()
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Cargando",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp, fontFamily = letterStyles.AmaranthFont)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tu aventura está a punto de comenzar",
                color = Color.LightGray,
                style = TextStyle(fontSize = 14.sp, fontFamily = letterStyles.AmaranthFont),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun BouncingDotsAnimation(
    dotSize: Dp = 16.dp,
    dotColor: Color = FourthColor,
    delayUnit: Int = 300
) {
    val animatables = List(3) { remember { Animatable(0f) } }

    animatables.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            delay(index * delayUnit.toLong())
            while (true) {
                animatable.animateTo(
                    targetValue = -10f,
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                )
                animatable.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
                )
            }
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        animatables.forEach { anim ->
            Box(
                modifier = Modifier
                    .offset(y = anim.value.dp)
                    .size(dotSize)
                    .background(dotColor, shape = CircleShape)
            )
        }
    }
}
