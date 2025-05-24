package com.example.planify

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.planify.navigation.navigationWrapper
import com.example.planify.screen.categories.ui.CategoriasScreen
import com.example.planify.screen.homePage.homePageScreen
import com.example.planify.ui.theme.PlanifyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlanifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navigationWrapper(Modifier.padding(innerPadding))

                }
            }
        }
    }
}





