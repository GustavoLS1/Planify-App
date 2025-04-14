package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.launch.launchScreen2
import com.example.planify.screen.login.loginScreen


@Composable
fun navigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = launchScreen2) {
        composable<launchScreen2> {
            launchScreen2(
                modifier = modifier, navigateToLoginScreen =
                    {
                        navController.navigate(loginScreen)
                    }
            )
        }
        composable<loginScreen> {
            loginScreen(modifier = Modifier)
        }
    }
}

