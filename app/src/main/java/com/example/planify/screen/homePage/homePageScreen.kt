package com.example.planify.screen.homePage

import android.R
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.SingleChoiceSegmentedButton
import com.example.planify.components.backgroundScreen
import com.example.planify.components.iconCategory
import com.example.planify.components.iconHome
import com.example.planify.components.iconNoteBook
import com.example.planify.components.iconNotifications
import com.example.planify.components.iconProfile
import com.example.planify.components.iconSearch
import com.example.planify.components.iconSettings
import com.example.planify.components.iconStatistics
import com.example.planify.components.roundedContainerScreen
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor
import com.example.planify.ui.theme.ThirdColor



@Composable
fun homePageScreen(modifier: Modifier = Modifier) {
//    Box(modifier = Modifier.fillMaxSize()) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomBottomBar()
        } // Aquí inyectás la barra inferior
    ) { paddingValues -> // Este padding se pasa para que el contenido no choque con la barra
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColor)
                .padding(paddingValues), // 👈 Importantísimo
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                iconProfile()
                Spacer(modifier = Modifier.width(15.dp))
                iconNotifications()
                Spacer(modifier = Modifier.width(130.dp))
                iconSearch()
                Spacer(modifier = Modifier.width(15.dp))
                iconStatistics()
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                SingleChoiceSegmentedButton()
            }
//                 Coloca todo el contenido dentro del RoundedContainerScreen
            roundedContainerScreen {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(text = "Contenido del RoundedContainerScreen")

                }
                // Aquí podés seguir agregando más contenido de tu pantalla
            }
        }
    }
}




@Composable
fun CustomBottomBar(modifier: Modifier = Modifier) {
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
                iconHome()
                iconCategory()
                iconNoteBook()
                iconSettings()
            }
        })
}


@Preview
@Composable
fun previewHomePageScreen() {
    homePageScreen(Modifier)
}

