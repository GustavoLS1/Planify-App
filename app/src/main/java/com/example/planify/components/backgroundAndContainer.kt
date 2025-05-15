package com.example.planify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.ThirdColor


//Componentes relacionadas con el pre-cargado inicial de la app
@Composable
fun backgroundLaunchScreen(modifier: Modifier, content: @Composable BoxScope.() -> Unit){
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
fun roundedContainerLaunchScreen(modifier: Modifier,content: @Composable BoxScope.() -> Unit){
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

//Componentes de la vista de home Page de la app
@Composable
fun backgroundScreen(modifier: Modifier, content: @Composable BoxScope.() -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        contentAlignment = Alignment.TopCenter
    ){
        content()
    }
}

@Composable
fun roundedContainerScreen(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 58.dp, topEnd = 58.dp))
            .background(ThirdColor),
        contentAlignment = Alignment.TopCenter
    ){
        content()
    }
}


