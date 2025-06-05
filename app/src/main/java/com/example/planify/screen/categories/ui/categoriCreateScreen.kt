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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CategoryFormScreen(
    isEditMode: Boolean,
    categoryName: String,
    onCategoryNameChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit,
    onBack: () -> Unit,
    viewModel: categoriesViewModel = viewModel()
) {

    val categoryName by viewModel.categoryName
    val isSaveEnabled by viewModel.isSaveEnabled

    val titleText = if (isEditMode) "Editar categoría" else "Agregar una categoría"
    val labelText = if (isEditMode) "Nombre" else "Nueva categoría"
    val buttonText = if (isEditMode) "Guardar" else "Crear"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
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
            onValueChange = viewModel::onCategoryNameChange,
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

        Spacer(modifier = Modifier.height(546.dp))

        // Botón principal
        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = FourthColor) // Lila claro
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
            colors = ButtonDefaults.buttonColors(containerColor = SecondColor) // Azul oscuro
        ) {
            Text("Cancelar", color = Color.White)
        }
    }
}

