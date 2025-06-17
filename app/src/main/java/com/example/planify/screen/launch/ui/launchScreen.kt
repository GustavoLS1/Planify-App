package com.example.planify.screen.launch.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.components.CircleWithImage
import com.example.planify.components.CircleWithImage2
import com.example.planify.components.backgroundLaunchScreen
import com.example.planify.components.backgroundScreen
import com.example.planify.components.buttonLogin
import com.example.planify.components.buttonLoginGoogle
import com.example.planify.components.buttonRegister
import com.example.planify.components.eclipseBottom
import com.example.planify.components.eclipseTop
import com.example.planify.components.logo
import com.example.planify.letterStyles
import kotlinx.coroutines.delay

@Composable
fun launchScreen1(
    modifier: Modifier,
    navigateTolaunchScreen2: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000L) // Espera 2 segundos
        navigateTolaunchScreen2()
    }
    backgroundLaunchScreen(modifier){
        Box(
            modifier = Modifier.align(Alignment.TopEnd)
        ){
            eclipseTop(modifier = Modifier)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(250.dp))
            logo()
            CircleWithImage2()
            Spacer(modifier = Modifier.height(30.dp))
        }
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ){
            eclipseBottom(modifier = Modifier)
        }
    }
}

@Composable
fun launchScreen2(
    modifier: Modifier,
    navigateToLoginScreen: () -> Unit,
    navigateToWelcomePlanify: () -> Unit
) {
    backgroundLaunchScreen(modifier){
        LazyColumn {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        eclipseTop(modifier = Modifier.align(Alignment.TopEnd))
                    }
                    logo()
                    CircleWithImage()
                    Spacer(modifier = Modifier.height(40.dp)) //Se debe analizar esta seccion de codigo
                    textWelcome()
                    Spacer(modifier = Modifier.height(30.dp))
                    buttonLogin(navigateTo = navigateToLoginScreen)
                    Spacer(modifier = Modifier.height(7.dp))
                    buttonRegister(navigateTo = navigateToWelcomePlanify)
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        eclipseBottom(modifier = Modifier.align(Alignment.BottomStart))
                    }
                }


            }
        }
    }
}

@Composable
fun textWelcome(){
    Text(
        text = "Bienvenido a Planify. Gestiona tus finanzas de forma fácil y eficiente. Inicia sesión y toma el control de tu dinero.",
        color = Color.White,
        textAlign = TextAlign.Center,
        style = TextStyle(fontFamily = letterStyles.AmaranthFont, fontSize = 18.sp),
        modifier = Modifier.fillMaxWidth(0.75f)
    )
}




@Preview(showBackground = true)
@Composable
fun PreviewLaunch2() {
    launchScreen2(modifier = Modifier, navigateToLoginScreen = { }, navigateToWelcomePlanify = { })
}