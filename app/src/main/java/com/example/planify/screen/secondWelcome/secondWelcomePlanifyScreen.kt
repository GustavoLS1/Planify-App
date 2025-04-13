package com.example.planify.screen.secondWelcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.planify.components.CircleImageSecondWelcome
import com.example.planify.components.CircleImageWelcome
import com.example.planify.components.RadioButtonGroup
import com.example.planify.components.textNext
import com.example.planify.components.textSecondWelcomePlanify
import com.example.planify.components.textWelcomePlanify
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.ThirdColor


@Composable
fun secondWelcomePlanifyScreen(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.size(116.dp))
            textSecondWelcomePlanify()
            Spacer(modifier = Modifier.size(116.dp))
            Body()


        }
    }
}


@Composable
fun Body() {
    Box(
        modifier = Modifier
            .fillMaxSize() //Otra forma de destacar el ancho y el alto
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
            CircleImageSecondWelcome()
            Spacer(modifier = Modifier.size(59.dp))
            textNext()
            RadioButtonGroup()
        }

    }
}
