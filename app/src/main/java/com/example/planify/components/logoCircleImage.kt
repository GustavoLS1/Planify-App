package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.ui.theme.SecondColor
import com.example.planify.R


@Composable
fun CircleWithImage2(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(SecondColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.imagelaunch),
            contentDescription = "Image Center",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun CircleWithImage(){
    Box(
        modifier = Modifier
            .size(190.dp)
            .background(SecondColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.imagelaunch),
            contentDescription = "Image Center",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun CircleImageWelcome(){
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.image_welcome),
            contentDescription = "Image Center",
            modifier = Modifier.size(283.dp)
        )
    }
}

@Composable
fun CircleImageSecondWelcome(){
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.image_secondwelcome),
            contentDescription = "Image Center",
            modifier = Modifier.size(283.dp)
        )
    }
}

@Composable
fun logo(){
        Image(
            painter = painterResource(id = R.drawable.logolaunch),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .heightIn(max = 112.dp)
        )
}

@Composable
@Preview
fun LogoPreview() {
    logo()
}