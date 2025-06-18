package com.example.planify.screen.homePage.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.BalanceSummaryCard
import com.example.planify.components.SelectableIcon
import com.example.planify.components.backgroundScreen
import com.example.planify.components.iconNotifications
import com.example.planify.components.iconSearch
import com.example.planify.components.roundedContainerScreen
import com.example.planify.ui.theme.SecondColor
import androidx.compose.runtime.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.DatePicker
import com.example.planify.components.FloatingActionHome
import com.example.planify.components.expenseCard
import com.example.planify.components.incomeCard
import com.example.planify.components.pupUpPlan
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.planify.screen.categories.ui.categoriesViewModel


@Composable
fun homePageScreen(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onNoteBookClick: () -> Unit,
    onCategoryClick: () -> Unit,
    viewModel: homePageViewModel = viewModel(),
    categories: categoriesViewModel = viewModel()
) {
    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var fabMenuExpanded by remember { mutableStateOf(false) }
    var showGastoDialog by remember { mutableStateOf(false) }
    var showIngresoDialog by remember { mutableStateOf(false) }

    val income by viewModel.income
    val expense by viewModel.expense
    val totalbalance by viewModel.totalbalance
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage
    val movements by viewModel.filteredMovements
    val context = LocalContext.current
    //val categorias by categories.displayedCategories

    // Listas de categorías filtradas
    val incomeCategories by remember { categories.incomeCategories }
    val expenseCategories by remember { categories.expenseCategories }

    LaunchedEffect(Unit) {
        viewModel.loadData(context)
        categories.loadCategories(context)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            modifier = modifier.zIndex(0f),
            bottomBar = {
                CustomBottomBar(
                    onSettingsClick = onSettingsClick,
                    onNoteBookClick = onNoteBookClick,
                    onCategoryClick = onCategoryClick
                )
            },
            floatingActionButton = { /* Vacío para evitar conflicto */ }
        ) { paddingValues ->

            backgroundScreen(modifier) {

                roundedContainerScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(900.dp)
                        .padding(top = 360.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Text(
                                text = "Movimientos",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            )
                        }
                        item {
                            if (isLoading) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Spacer(modifier = Modifier.height(200.dp))
                                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                                }

                            }
                        }
                        items(items = movements.chunked(3)) { row ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .height(100.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                row.forEach { movimiento ->
                                    when (movimiento.type) {
                                        typeMovements.INCOME -> incomeCard(
                                            titulo = movimiento.title,
                                            monto = movimiento.amount.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(100.dp)
                                        )
                                        typeMovements.EXPENSE -> expenseCard(
                                            titulo = movimiento.title,
                                            monto = movimiento.amount.toString(),
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(100.dp)

                                        )
                                    }
                                }

                                // Rellenar para que la fila tenga siempre 3 elementos visibles
                                /*repeat(3 - row.size) {
                                    Box(modifier = Modifier.weight(1f).height(100.dp))
                                }*/
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(100.dp))
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 16.dp)
                            .height(56.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (showSearch) {
                            TextField(
                                value = viewModel.searchQuery.value,
                                onValueChange = { viewModel.updateSearchQuery(it) },
                                placeholder = { Text("Buscar...") },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                shape = RoundedCornerShape(12.dp),
                                singleLine = true,
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = Color.Black,
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent
                                ),
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Cerrar búsqueda",
                                        modifier = Modifier.clickable {
                                            showSearch = false
                                            viewModel.updateSearchQuery("") // <- Limpia el estado del ViewModel
                                        }
                                    )
                                }
                            )
                        } else {
                            iconSearch {
                                showSearch = true
                            }
                            Spacer(modifier = Modifier.width(250.dp))
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        iconNotifications {
                            println("Notifications presionado")
                        }
                    }


                    errorMessage?.let {
                        Text(
                            text = it,
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        BalanceSummaryCard(
                            saldoTotal = "$${totalbalance.format(2)}",
                            ingresos = "$${income.format(2)}",
                            gastos = "$${expense.format(2)}"
                        )
                    }

                    Spacer(modifier = Modifier.height(19.dp))

                    Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                        DatePicker()
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        if (fabMenuExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            fabMenuExpanded = false
                        })
                    }
                    .zIndex(1f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(2f)
        ) {
            FloatingActionHome(
                expanded = fabMenuExpanded,
                onExpandedChange = { fabMenuExpanded = !fabMenuExpanded },
                onGastoClick = {
                    fabMenuExpanded = false
                    showGastoDialog = true
                },
                onIngresoClick = {
                    fabMenuExpanded = false
                    showIngresoDialog = true
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = (-122).dp)
                    .navigationBarsPadding()
            )
        }

        //println("Income categories: ${incomeCategories.map { it.name }}")
        //println("Expense categories: ${expenseCategories.map { it.name }}")

        pupUpPlan(
            title = "Nuevo ingreso",
            context = context,
            showDialog = showIngresoDialog,
            categorias = incomeCategories,
            onDismiss = { showIngresoDialog = false },
            onSave = { dto ->
                viewModel.createTransaction(dto, context)
            }
        )

        pupUpPlan(
            title = "Nuevo gasto",
            context = context,
            showDialog = showGastoDialog,
            onDismiss = { showGastoDialog = false },
            categorias = expenseCategories,
            onSave = { dto ->
                viewModel.createTransaction(dto, context)
            }
        )
    }
}



fun Double.format(digits: Int) = "%.${digits}f".format(this)


@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onNoteBookClick: () -> Unit,
    onCategoryClick: () -> Unit
) {
    BottomAppBar(
        modifier = modifier
            .height(80.dp)
            .clip(RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp)),
        containerColor = SecondColor,
        content = {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                    //.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                SelectableIcon(
                    iconRes = R.drawable.icon_home,
                    contentDescription = "Home",
                    onClick = {} // -> aca iran las navegaciones
                )

                SelectableIcon(
                    iconRes = R.drawable.icon_category,
                    contentDescription = "Category",
                    onClick = onCategoryClick
                )

                SelectableIcon(
                    iconRes = R.drawable.icon_notebook,
                    contentDescription = "NoteBook",
                    onClick = onNoteBookClick
                )

                SelectableIcon(
                    iconRes = R.drawable.icon_settings,
                    contentDescription = "Setting",
                    onClick = onSettingsClick
                )

            }
        }
    )
}


@Preview
@Composable
fun PreviewHomePageScreen() {
    homePageScreen(onSettingsClick = {}, onNoteBookClick = {}, onCategoryClick = {})
}



