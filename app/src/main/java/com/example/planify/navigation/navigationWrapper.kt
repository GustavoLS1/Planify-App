package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.launch.launchScreen2
import com.example.planify.screen.login.loginScreen
import com.example.planify.screen.register.registerScreen
import com.example.planify.screen.welcome.welcomePlanifyScreen


@Composable
fun navigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = launchScreen2) {
        composable<launchScreen2> {
            launchScreen2(
                modifier = modifier, navigateToLoginScreen =
                    {
                        navController.navigate(loginScreen)
                    }, navigateToWelcomePlanify = {
                        navController.navigate(welcomePlanifyScreen)
                }
            )
        }
        composable<loginScreen> {
            loginScreen(
                modifier = modifier,
                navegateToRegister = {
                    navController.navigate(register)
                }
            )
        }
        composable<register> {
            registerScreen(modifier = modifier){
                navController.navigate(welcomePlanifyScreen)
            }
        }
        composable<welcomePlanifyScreen> {
            welcomePlanifyScreen(modifier = modifier) {

            }
        }

    }
}

