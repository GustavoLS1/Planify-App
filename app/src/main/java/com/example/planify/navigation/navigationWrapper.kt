package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.login.loginScreen
import com.example.planify.screen.register.registerScreen


@Composable
fun navigationWrapper (modifier: Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = login){
        composable<login>{
            loginScreen(modifier = modifier,
                navegateToRegister = {
                    navController.navigate(register)
                }
            )
        }
        composable<register>{
            registerScreen(modifier = modifier)
        }
    }
}

