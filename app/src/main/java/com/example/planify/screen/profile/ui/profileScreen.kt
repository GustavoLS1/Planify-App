package com.example.planify.screen.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.planify.components.HeaderSection
import com.example.planify.components.ProfileContent

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onEditProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutClick: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF070F2B)) // Fondo azul oscuro
        ) {
            HeaderSection(onBackClick = onBackClick)
            ProfileContent(
                onEditProfileClick = onEditProfileClick,
                onSettingsClick = onSettingsClick,
                onLogoutClick = onLogoutClick
            )
        }
    }
}

@Preview
@Composable
fun previes() {
    ProfileScreen(onBackClick = {  }, onEditProfileClick = {  }, onSettingsClick = {  }, onLogoutClick = {  })
}