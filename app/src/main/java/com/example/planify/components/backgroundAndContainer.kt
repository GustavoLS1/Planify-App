package com.example.planify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.ThirdColor

@Composable
fun backgroundScreen(modifier: Modifier, content: @Composable BoxScope.() -> Unit){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.TopCenter
    ){
        content()
    }
}

@Composable
fun roundedContainerScreen(modifier: Modifier,content: @Composable BoxScope.() -> Unit){
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(ThirdColor),
        contentAlignment = Alignment.TopCenter
    ){
        content()
    }
}
