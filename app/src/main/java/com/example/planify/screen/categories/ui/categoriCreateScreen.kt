package com.example.planify.screen.categories.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryFormScreen(
    isEditMode: Boolean,
    categoryName: String,
    onCategoryNameChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit,
    onBack: () -> Unit
) {
    val titleText = if (isEditMode) "Editar categoría" else "Agregar una categoría"
    val labelText = if (isEditMode) "Nombre" else "Nueva categoría"
    val buttonText = if (isEditMode) "Guardar" else "Crear"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0F2C))
            .padding(24.dp)
    ) {
        // Título con botón de volver
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
            Text(
                text = titleText,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Etiqueta
        Text(text = labelText, color = Color.White)

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de texto
        TextField(
            value = categoryName,
            onValueChange = onCategoryNameChange,
            placeholder = { Text("Nombre", color = Color.DarkGray) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
                disabledContainerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón principal
        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB9B9F2)) // Lila claro
        ) {
            Text(buttonText, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón cancelar
        Button(
            onClick = onCancel,
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F3FFD)) // Azul oscuro
        ) {
            Text("Cancelar", color = Color.White)
        }
    }
}

//@Preview
//@Composable
//fun previe() {
//    var categoryName by remember { mutableStateOf("") }
//
//    CategoryFormScreen(
//        isEditMode = false, // o true para editar
//        categoryName = categoryName,
//        onCategoryNameChange = { categoryName = it },
//        onSave = { /* guardar */ },
//        onCancel = { /* volver atrás */ },
//        onBack = { /* navegar */ }
//    )
//}