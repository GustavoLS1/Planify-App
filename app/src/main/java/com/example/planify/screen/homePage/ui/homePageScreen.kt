package com.example.planify.screen.homePage.ui

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.DatePicker
import com.example.planify.components.FloatingActionHome
import com.example.planify.components.pupUpPlan

@Composable
fun homePageScreen(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onNoteBookClick: () -> Unit,
    onCategoryClick: () -> Unit,
    viewModel: homePageViewModel = viewModel()
) {
    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var fabMenuExpanded by remember { mutableStateOf(false) }
    var showGastoDialog by remember { mutableStateOf(false) }
    var showIngresoDialog by remember { mutableStateOf(false) }

    val ingresos by viewModel.ingresos
    val gastos by viewModel.gastos
    val saldoTotal by viewModel.saldoTotal
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage

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
                        .padding(top = 350.dp)
                ) {
                    // Fondo o contenido
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
                            OutlinedTextField(
                                value = searchText,
                                onValueChange = { searchText = it },
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
                                            searchText = TextFieldValue("")
                                        }
                                    )
                                }
                            )
                        } else {
                            iconSearch {
                                showSearch = true
                            }
                            Spacer(modifier = Modifier.width(270.dp))
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        iconNotifications {
                            println("Notifications presionado")
                        }
                    }

                    if (isLoading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
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
                            saldoTotal = "$${saldoTotal.format(2)}",
                            ingresos = "$${ingresos.format(2)}",
                            gastos = "$${gastos.format(2)}"
                        )
                    }

                    Spacer(modifier = Modifier.height(19.dp))

                    Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                        DatePicker()
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Contenido dentro del RoundedContainerScreen",
                            color = Color.White
                        )
                    }
                }
            }
        }

        // Overlay oscuro solo si FAB expandido
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

        // Contenedor para posicionar el FAB con mayor control
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

        // Pop-ups ingreso y gasto
        pupUpPlan(
            title = "Nuevo ingreso",
            showDialog = showIngresoDialog,
            onDismiss = { showIngresoDialog = false },
            onSave = { amount ->
                viewModel.agregarIngreso(amount)
            }
        )

        pupUpPlan(
            title = "Nuevo gasto",
            showDialog = showGastoDialog,
            onDismiss = { showGastoDialog = false },
            onSave = { amount ->
                viewModel.agregarGasto(amount)
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
            .clip(RoundedCornerShape(topStart = 42.dp, topEnd = 42.dp)),
        containerColor = SecondColor,
        content = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(horizontal = 16.dp),
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



