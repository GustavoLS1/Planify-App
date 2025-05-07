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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.FloatingActionMenu
import com.example.planify.components.GastosResumen
import com.example.planify.components.Header
import com.example.planify.components.MetasList

@Composable
fun LibretaScreen() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C0D36)) // Fondo general
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header()
            GastosResumen()
            Spacer(modifier = Modifier.height(16.dp))
            MetasList()
        }

        FloatingActionMenu(expanded = expanded) {
            expanded = !expanded
        }
    }
}

@Preview
@Composable
fun previe(){
    LibretaScreen()
}