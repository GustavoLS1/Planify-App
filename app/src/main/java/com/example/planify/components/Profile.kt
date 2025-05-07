package com.example.planify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, color = Color.White)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun PasswordField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, color = Color.White, fontSize = 14.sp)
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("••••••••") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.DarkGray,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun SettingOptionItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    val optionColor = Color(0xFF0D0D4B)

    Surface(
        color = optionColor,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text, color = Color.White, modifier = Modifier.weight(1f))
            Icon(Icons.Default.ArrowForwardIos, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
        }
    }
}