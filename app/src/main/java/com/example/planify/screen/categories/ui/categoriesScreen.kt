package com.example.planify.screen.categories.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.components.CategoriaItem
import com.example.planify.components.SearchBar
import com.example.planify.components.TabButton
import com.example.planify.ui.theme.PrimaryColor

@Composable
fun CategoriasScreen(
    onEditCategory: (String) -> Unit,
    onAddCategory: () -> Unit,
    onBack: () -> Unit,
    viewModel: categoriesViewModel = viewModel()
) {
    val selectedTab by viewModel.selectedType
    val searchQuery by viewModel.searchQuery
    val categorias by viewModel.displayedCategories
    val isLoading by viewModel.isLoading
    val errorMassage by viewModel.errorMessage

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadCategories(context)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(Modifier.width(8.dp))
            Text(
                "Categorías",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF1B1F3B))
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TabButton("INGRESOS", selectedTab == "INGRESOS") {
                    viewModel.setCategoryType("INGRESOS")
                }
                TabButton("GASTOS", selectedTab == "GASTOS") {
                    viewModel.setCategoryType("GASTOS")
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        SearchBar(
            query = searchQuery,
            onQueryChanged = viewModel::onQueryChanged,
            onAddClick = onAddCategory // Llama a crear
        )

        Spacer(Modifier.height(16.dp))

        when {
            isLoading -> {
                CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally))
            }

            errorMassage != null -> {
                Text(
                    text = errorMassage ?: "",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            else -> {
                LazyColumn {
                    items(categorias) { categoria ->
                        CategoriaItem(
                            nombre = categoria.name,
                            onClick = { /* eliminar */ },
                            onEditClick = { onEditCategory(categoria.name) }
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}




