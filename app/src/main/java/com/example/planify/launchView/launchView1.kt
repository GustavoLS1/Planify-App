package com.example.planify.launchView

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
import com.example.planify.Components.CircleWithImage2
import com.example.planify.Components.eclipseBottom
import com.example.planify.Components.eclipseTop
import com.example.planify.Components.logo
import com.example.planify.ui.theme.PrimaryColor

@Composable
fun launchView(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier.align(Alignment.TopEnd)
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
    launchView(modifier = Modifier)
}
