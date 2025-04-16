package com.example.planify.screen.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.CircleImageSecondWelcome
import com.example.planify.components.CircleImageWelcome
import com.example.planify.components.RadioButtonGroup
import com.example.planify.components.backgroundScreen
import com.example.planify.components.roundedContainerScreen
import com.example.planify.components.textNext
import com.example.planify.components.textWelcomePlanify
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.ThirdColor
import kotlinx.coroutines.selects.select


@Composable
fun welcomePlanifyScreen(modifier: Modifier, navigateToSecondWelcome: () -> Unit) {
    var currentStep by rememberSaveable { mutableStateOf(1) }
    backgroundScreen{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.size(116.dp))
            textWelcomePlanify()
            Spacer(modifier = Modifier.size(116.dp))
            Body(currentStep = currentStep, onStepChange = { currentStep = it })


        }
    }
}


@Composable
fun Body(currentStep: Int, onStepChange: (Int) -> Unit) {
    roundedContainerScreen{
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentStep) {
                1 -> {
                    CircleImageWelcome()
                    Spacer(modifier = Modifier.size(59.dp))
                    textNext()

                }

                2 -> {
                    CircleImageSecondWelcome()
                    Spacer(modifier = Modifier.size(59.dp))
                    textNext()

                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            RadioButtonGroup(
                selectedIndex = currentStep,
                onClick = { onStepChange(it) }
            )

        }

    }
}

