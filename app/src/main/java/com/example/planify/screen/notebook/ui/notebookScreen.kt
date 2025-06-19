package com.example.planify.screen.notebook.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.planify.components.AmountPopUp
import com.example.planify.components.FloatingActionMenu
import com.example.planify.components.Header
import com.example.planify.components.MetasList
import com.example.planify.components.SummaryIncome
import com.example.planify.components.backgroundLaunchScreen
import com.example.planify.screen.homePage.ui.CustomBottomBar
import com.example.planify.ui.theme.PrimaryColor


//@Composable
//fun LibretaScreen(
//    navController: NavController,
//    onAddGoalClick: () -> Unit = {},
//    viewModel: notebookViewModel = viewModel()
//) {
//    val expanded by viewModel.expanded
//    val isModalOpen by viewModel.isModalOpen
//    val selectedGoal by viewModel.selectedGoal
//    val goals = viewModel.goals // Lista de metas, puedes obtenerla del ViewModel
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(PrimaryColor) // Fondo general
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Header(
//                onBackClick = {navController.popBackStack()},
//                metas = goals
//            )
//            SummaryIncome(metas = goals)
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Simulación de lista de metas (puedes traerlo del estado real)
//            MetasList(
//                metas = viewModel.goals,
//                onAmountAdded = { meta, monto ->
//                    viewModel.addAmountToGoal(meta, monto)
//                }
//            )
//        }
//
//        if (isModalOpen && selectedGoal != null) {
//            val (nombre, valores) = selectedGoal!!
//            val (actual, total) = valores
//            AmountPopUp(
//                nombre = nombre,
//                actual = actual,
//                total = total,
//                onAmountAdded = { amount ->
//                    viewModel.addAmountToGoal(meta = goal(nombre, actual, total), monto = amount)
//                },
//                onDismiss = { viewModel.closeAmountModal() }
//            )
//        }
//
//        FloatingActionMenu(
//            expanded = expanded,
//            onExpandedChange = { viewModel.toggleExpanded() },
//            onAddGoalClick = {
//                onAddGoalClick()
//                viewModel.toggleExpanded() // cerrar menú al navegar
//            }
//        )
//
//    }
//}

@Composable
fun LibretaScreen(
    modifier: Modifier,
    navController: NavController,
    onAddGoalClick: () -> Unit = {},
    onSettingsClick: () -> Unit,
    onNoteBookClick: () -> Unit,
    onCategoryClick: () -> Unit,
    viewModel: notebookViewModel = viewModel(),
    onHomeClick: () -> Unit
) {
    val expanded by viewModel.expanded
    val isModalOpen by viewModel.isModalOpen
    val selectedGoal by viewModel.selectedGoal
    val goals = viewModel.goals

   backgroundLaunchScreen(modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp) // deja espacio para que el bottom bar no tape contenido
        ) {
            Header(
                onBackClick = { navController.popBackStack() },
                metas = goals
            )

            SummaryIncome(metas = goals)
            Spacer(modifier = Modifier.height(16.dp))

            MetasList(
                metas = goals,
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

        FloatingActionMenu(
            expanded = expanded,
            onExpandedChange = { viewModel.toggleExpanded() },
            onAddGoalClick = {
                onAddGoalClick()
                viewModel.toggleExpanded()
            }
        )

        Spacer(modifier = Modifier.height(56.dp))

        // Aquí se muestra el CustomBottomBar anclado al fondo
        CustomBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onHomeClick = onHomeClick,
            onSettingsClick = onSettingsClick,
            onNoteBookClick = onNoteBookClick,
            onCategoryClick = onCategoryClick
        )
    }
}


//@Preview
//@Composable
//fun previe(){
//    LibretaScreen()
//}