package com.example.planify.screen.notebook.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.planify.components.AmountPopUp
import com.example.planify.components.FloatingActionMenu
import com.example.planify.components.Header
import com.example.planify.components.MetaItem
import com.example.planify.components.MetasList
import com.example.planify.components.SummaryIncome
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.ThirdColor

@Composable
fun LibretaScreen(
    navController: NavController,
    viewModel: notebookViewModel = viewModel()
) {
    val expanded by viewModel.expanded
    val isModalOpen by viewModel.isModalOpen
    val selectedGoal by viewModel.selectedGoal
    val goals = viewModel.goals // Lista de metas, puedes obtenerla del ViewModel

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor) // Fondo general
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header(
                onBackClick = {navController.popBackStack()},
                metas = goals
            )
            SummaryIncome(metas = goals)
            Spacer(modifier = Modifier.height(16.dp))

            // Simulación de lista de metas (puedes traerlo del estado real)
            MetasList(
                metas = viewModel.goals,
                onAmountAdded = { meta, monto ->
                    viewModel.addAmountToGoal(meta, monto)
                }
            )
        }

        if (isModalOpen && selectedGoal != null) {
            val (nombre, valores) = selectedGoal!!
            val (actual, total) = valores
            AmountPopUp(
                nombre = nombre,
                actual = actual,
                total = total,
                onAmountAdded = { amount ->
                    viewModel.addAmountToGoal(meta = goal(nombre, actual, total), monto = amount)
                },
                onDismiss = { viewModel.closeAmountModal() }
            )
        }

        FloatingActionMenu(expanded) {
            viewModel.toggleExpanded()
        }
    }
}

//@Preview
//@Composable
//fun previe(){
//    LibretaScreen()
//}