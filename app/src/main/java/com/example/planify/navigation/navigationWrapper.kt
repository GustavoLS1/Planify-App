package com.example.planify.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.forgetPassword.ui.forgetPasswordScreen
import com.example.planify.screen.launch.ui.launchScreen1
import com.example.planify.screen.launch.ui.launchScreen2
import com.example.planify.screen.login.ui.loginScreen
import com.example.planify.screen.register.ui.registerScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyScreen
import com.example.planify.screen.welcome.ui.welcomePlanifyViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = launchScreen1) {
        composable<launchScreen1> {
            launchScreen1(
                modifier = modifier,
                navigateTolaunchScreen2 = {
                    navController.navigate(launchScreen2)
                }
            )
        }

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
                },
                navegateToForgetPassword = {
                    navController.navigate(forgetPasswordScreen)
                }
            )
        }

        composable<forgetPasswordScreen> {
            forgetPasswordScreen(modifier = modifier,
                navigateToLogin = {
                    navController.navigate(loginScreen)
                }
            )
        }

        composable<register> {
            registerScreen(modifier = modifier
            , function ={

                }
            )
        }

        composable<welcomePlanifyScreen> { navBackStackEntry ->
            val viewModel: welcomePlanifyViewModel = viewModel(navBackStackEntry)
            welcomePlanifyScreen(
                modifier = modifier,
                viewModel = viewModel,
                navigateToSecondWelcome = {
                    navController.navigate(register)
                }
            )

        }

    }
}

