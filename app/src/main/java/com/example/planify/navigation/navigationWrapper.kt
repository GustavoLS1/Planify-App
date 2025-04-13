package com.example.planify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun navigationWrapper (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ""){

    }
}

