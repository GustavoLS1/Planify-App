package com.example.planify.screen.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.SettingOptionItem

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onPasswordClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    val darkBlue = Color(0xFF0D0D4B)
    val purpleBlue = Color(0xFF1D1F6F)
    val optionColor = Color(0xFF2D2E80)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(start = 16.dp, top = 24.dp)
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Configuración",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Content Box
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = purpleBlue,
                        shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 48.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Opción 1: Configura tu contraseña
                    SettingOptionItem(
                        icon = Icons.Default.Key, // Puedes reemplazar por otro
                        text = "Configura tu contraseña",
                        onClick = onPasswordClick
                    )

                    // Opción 2: Configura tu perfil
                    SettingOptionItem(
                        icon = Icons.Default.Person,
                        text = "Configura tu perfil",
                        onClick = onProfileClick
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun preview(){
//    SettingsScreen(
//        onBackClick = {  },
//        onPasswordClick = {  },
//        onProfileClick = {  }
//    )
//}