package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.R

@Composable
fun ProfileContent(onEditProfileClick: () -> Unit,
                   onSettingsClick: () -> Unit,
                   onLogoutClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1A55), shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 60.dp, bottom = 80.dp)
        ) {
            // Foto de perfil superpuesta
            Box(modifier = Modifier
                .offset(y = -100.dp)
                .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile), // tu imagen
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }

            Text("John Smith", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(24.dp))

            ProfileOption(icon = Icons.Default.Person, text = "Editar perfil", onClick = onEditProfileClick)
            Spacer(modifier = Modifier.height(15.dp))
            ProfileOption(icon = Icons.Default.Settings, text = "Configuración", onClick = onSettingsClick)
            Spacer(modifier = Modifier.height(15.dp))
            ProfileOption(icon = Icons.Default.ExitToApp, text = "Cerrar sesión", onClick = onLogoutClick)
        }
    }
}

//@Preview
//@Composable
//fun profileContent(){
//    ProfileContent()
//}