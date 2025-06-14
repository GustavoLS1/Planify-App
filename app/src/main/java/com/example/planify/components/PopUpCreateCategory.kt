package com.example.planify.components

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.window.Dialog
import com.example.planify.screen.categories.ui.data.response.categoryDto
import com.example.planify.screen.homePage.ui.data.response.transactionCreateResponseDto
import com.example.planify.screen.homePage.ui.data.response.transactionResponseDto


@Composable
fun pupUpPlan(
    title: String,
    context: Context,
    showDialog: Boolean,
    categorias: List<categoryDto>,
    onDismiss: () -> Unit,
    onSave: (transactionCreateResponseDto) -> Unit
) {

    var cantidadText by remember { mutableStateOf("") }
    var selectedCategory by remember {
        mutableStateOf(
            categorias.firstOrNull() ?: categoryDto(0, "Sin categoría", 0, "", 0, false)
        )
    }

    LaunchedEffect(categorias) {
        Log.d("DEBUG", "Categorias recibidas: $categorias")
        selectedCategory = categorias.firstOrNull() ?: categoryDto(0, "Sin categoría", 0, "", 0, false)
    }

    var nombre by remember { mutableStateOf("") }

    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Box(
                modifier = Modifier
                    .size(361.dp, 725.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF1B1464))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        buttonClouse {
                            onDismiss()
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Categoría", color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    CategoriaDropdown(
                        categorias = categorias,
                        selectedCategory = selectedCategory.name,
                        onCategorySelected = { nombreCategoria ->
                            selectedCategory =
                                categorias.find { it.name == nombreCategoria } ?: categoryDto(0, "Sin categoría", 0, "", 0, false)
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Cantidad", color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    CurrencyTextField(
                        value = cantidadText,
                        onValueChange = { cantidadText = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Fecha", color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    DatePicker()

                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Nombre", color = Color.White)
                    Spacer(modifier = Modifier.height(5.dp))
                    NombreTextField(
                        nombre = nombre,
                        onNombreChange = { nuevoNombre ->
                            nombre = nuevoNombre.take(13)
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    buttonCreate {
                        val cantidad = cantidadText
                            .replace("[^\\d.]".toRegex(), "")
                            .toDoubleOrNull()
                        if (cantidad != null && nombre.isNotBlank()) {
                            val dto = transactionCreateResponseDto(
                                description = nombre,
                                amount = cantidad,
                                categoryId = selectedCategory.id
                            )

                            onSave(dto)
                            onDismiss()
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    buttonCancel {
                        onDismiss()
                    }
                }
            }
        }
    }
}
