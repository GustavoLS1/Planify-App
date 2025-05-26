package com.example.planify.screen.notebook.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.components.backgroundScreen
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.TextStyle
import com.example.planify.components.CurrencyTextField
import com.example.planify.components.CurrencyTextFieldNotebook
import com.example.planify.components.DatePicker
import com.example.planify.components.Name
import com.example.planify.components.Number
import com.example.planify.components.buttonCancel
import com.example.planify.components.buttonCreate
import com.example.planify.letterStyles

@Composable
fun NotebookAddScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    viewModel: notebookViewModel = viewModel()
) {

    val name by viewModel.name
    val dateGoal by viewModel.dateGoal
    val amount by viewModel.amount

    backgroundScreen(modifier = Modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Libreta",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            Column(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Nombre del ahorro",
                    color =Color.White,
                    style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Name(name) {
                    viewModel.onNotebookChange(
                        name = it,
                        dateGoal = dateGoal,
                        amount = amount
                    )
                }
                Spacer(modifier = Modifier.height(19.dp))
                Text(
                    text = "Meta",
                    color = Color.White,
                    style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                DatePicker()
                Spacer(modifier = Modifier.height(19.dp))
                Text(
                    text = "Monto",
                    color = Color.White,
                    style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                CurrencyTextFieldNotebook {
                    val numericValue = it.filter { c -> c.isDigit() }.toIntOrNull() ?: 0
                    viewModel.onNotebookChange(
                        name = name,
                        dateGoal = dateGoal,
                        amount = numericValue
                    )
                }
                Spacer(modifier = Modifier.height(200.dp))
                buttonCreate {
                    onSaveClick
                }
                Spacer(modifier = Modifier.height(15.dp))
                buttonCancel {
                    onBackClick()
                }
            }
        }

    }
}