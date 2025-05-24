package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planify.R
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor

@Composable
fun iconNotifications(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_notifications),
        contentDescription = "Icon notifications",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconSearch(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_search),
        contentDescription = "Icon search",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SelectableIcon(
    iconRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .size(60.dp)
            .background(
                color = if (isPressed) PrimaryColor else SecondColor,
                shape = RoundedCornerShape(12.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        val success = tryAwaitRelease()
                        isPressed = false
                        if (success) {
                            onClick()
                        }
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id =iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(36.dp),
            contentScale =  ContentScale.Fit,
            alpha = if (isPressed) 0.8f else 1f
        )
    }
}