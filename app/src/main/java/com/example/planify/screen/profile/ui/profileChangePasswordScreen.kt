package com.example.planify.screen.profile.ui

import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasswordChangeScreen(onBackClick: () -> Unit) {
    val darkBlue = Color(0xFF0D0D4B)
    val purpleBlue = Color(0xFF1D1F6F)
    val fieldColor = Color(0xFFE0E0E0)
    val buttonColor = Color(0xFFBDBDFF)

    val textFieldColors = TextFieldDefaults.colors(
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        disabledTextColor = Color.DarkGray,
        focusedPlaceholderColor = Color.Gray,
        unfocusedPlaceholderColor = Color.Gray
    )

    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlue)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top App Bar
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
                    text = "Configura tu contraseña",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Main Card / Panel
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Campos de texto
                    TextField(
                        value = currentPassword,
                        onValueChange = { currentPassword = it },
                        placeholder = { Text("Contraseña actual:") },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = textFieldColors,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    TextField(
                        value = newPassword,
                        onValueChange = { newPassword = it },
                        placeholder = { Text("Nueva contraseña:") },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = textFieldColors,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    TextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholder = { Text("Confirmar contraseña:") },
                        visualTransformation = PasswordVisualTransformation(),
                        colors = textFieldColors,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Botón Cambiar la contraseña
                    Button(
                        onClick = { /* Acción de cambio de contraseña */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
                    ) {
                        Text("Cambiar la contraseña", color = Color.Black)
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun previews(){
//    PasswordChangeScreen(onBackClick = { })
//}