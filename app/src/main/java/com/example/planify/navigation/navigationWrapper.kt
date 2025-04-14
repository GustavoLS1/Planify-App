package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planify.screen.login.loginScreen


@Composable
fun navigationWrapper (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable<Login>{
            loginScreen{ navController.navigate("welcomePlanifyScreen") }
        }
    }
}

