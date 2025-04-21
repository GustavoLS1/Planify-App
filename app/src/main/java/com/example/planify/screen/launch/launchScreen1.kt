package com.example.planify.screen.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.CircleWithImage2
import com.example.planify.components.backgroundScreen
import com.example.planify.components.eclipseBottom
import com.example.planify.components.eclipseTop
import com.example.planify.components.logo
import com.example.planify.ui.theme.PrimaryColor

@Composable
fun launchScreen1(modifier: Modifier) {
    backgroundScreen{
        Box(
            modifier = modifier.align(Alignment.TopEnd)
        ){
            eclipseTop()
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(250.dp))
            logo()
            CircleWithImage2()
            Spacer(modifier = Modifier.height(30.dp))
        }
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ){
            eclipseBottom()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun previewLaunch() {
    launchScreen1(modifier = Modifier)
}
