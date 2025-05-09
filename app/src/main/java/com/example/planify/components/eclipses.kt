package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planify.R

@Composable
fun eclipseTop(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.eclipse),
        contentDescription = "Top Eclipse",
        modifier = modifier.size(120.dp)
    )
}

@Composable
fun eclipseBottom(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.eclipse2),
        contentDescription = "Top Eclipse",
        modifier = modifier.size(120.dp)
    )
}