package com.example.planify.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planify.R

@Composable
fun eclipseTop(){
    Image(
        painter = painterResource(id = R.drawable.eclipse),
        contentDescription = "Top Eclipse",
        modifier = Modifier.size(120.dp)
    )
}

@Composable
fun eclipseBottom(){
    Image(
        painter = painterResource(id = R.drawable.eclipse2),
        contentDescription = "Top Eclipse",
        modifier = Modifier.size(120.dp)
    )
}