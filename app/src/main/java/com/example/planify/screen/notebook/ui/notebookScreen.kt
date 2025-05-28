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
import com.example.planify.components.FloatingActionMenu
import com.example.planify.components.Header
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
                onBackClick = {navController.popBackStack()}
            )
            SummaryIncome()
            Spacer(modifier = Modifier.height(16.dp))
            MetasList()
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