package com.example.planify.screen.homePage

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.BalanceSummaryCard
import com.example.planify.components.SelectableIcon
import com.example.planify.components.backgroundScreen
import com.example.planify.components.iconNotifications
import com.example.planify.components.iconSearch
import com.example.planify.components.roundedContainerScreen
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.SecondColor

@Composable
fun homePageScreen(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onNoteBookClick: () -> Unit,
    onCategoryClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomBottomBar(
                onSettingsClick = onSettingsClick,
                onNoteBookClick = onNoteBookClick,
                onCategoryClick = onCategoryClick

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //Accion que sucede cuando se presiona el boton
                    println("Boton presionado")

                },
                containerColor = FourthColor,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                modifier = Modifier.offset(y = (-20).dp)
            ) {
                Image(
                    painter = painterResource(id = com.example.planify.R.drawable.floatingbutton),
                    contentDescription = "Add",
                    modifier = Modifier.size(45.dp)
                )
            }

        }
    ) { paddingValues ->

        // 👉 Ahora usamos un Box para manejar fondo y contenido separados
        Box(modifier = Modifier.fillMaxWidth()) {

            backgroundScreen(modifier) {

            }
            roundedContainerScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(900.dp)
                    .padding(top = 300.dp)
            ) {
                // Podés dejar vacío o meter fondo de pantalla acá

            }

            // Contenido principal: Column que respeta el padding
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Ahora SOLO este contenido respeta el BottomBar
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(27.dp)
                ) {
                    Spacer(modifier = Modifier.width(5.dp))
                    iconSearch { println("Search presionado") }
                    Spacer(modifier = Modifier.width(245.dp))
                    iconNotifications { println("Notifications presionado") }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    BalanceSummaryCard(
                        saldoTotal = "$50.000",
                        ingresos = "",
                        gastos = ""
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
}

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
                    iconRes = com.example.planify.R.drawable.icon_home,
                    contentDescription = "Home",
                    onClick = {} // -> aca iran las navegaciones
                )

                SelectableIcon(
                    iconRes = com.example.planify.R.drawable.icon_category,
                    contentDescription = "Category",
                    onClick = onCategoryClick
                )

                SelectableIcon(
                    iconRes = com.example.planify.R.drawable.icon_notebook,
                    contentDescription = "NoteBook",
                    onClick = onNoteBookClick
                )

                SelectableIcon(
                    iconRes = com.example.planify.R.drawable.icon_settings,
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



