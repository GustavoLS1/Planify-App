package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.launch.launchScreen2
import com.example.planify.screen.login.ui.loginScreen
import com.example.planify.screen.register.ui.registerScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyViewModel


@Composable
fun navigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = launchScreen2) {
        composable<launchScreen2> {
            launchScreen2(
                modifier = modifier,
                navigateToLoginScreen =
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
            registerScreen(modifier = modifier
            , function ={
                    navController.navigate(welcomePlanifyScreen)
                }
            )
        }

        composable<welcomePlanifyScreen> { navBackStackEntry ->
            val viewModel: welcomePlanifyViewModel = viewModel(navBackStackEntry)
            welcomePlanifyScreen(
                modifier = modifier,
                viewModel = viewModel,
                navigateToSecondWelcome = {

                }
            )

        }

    }
}

