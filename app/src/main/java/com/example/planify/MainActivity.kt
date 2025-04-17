package com.example.planify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.planify.navigation.navigationWrapper
import com.example.planify.screen.launch.launchScreen2
import com.example.planify.screen.register.registerScreen
import com.example.planify.screen.welcome.welcomePlanifyScreen
import com.example.planify.ui.theme.PlanifyTheme

class MainActivity : ComponentActivity() {
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





