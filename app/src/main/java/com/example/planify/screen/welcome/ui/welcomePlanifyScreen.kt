package com.example.planify.screen.welcome.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.components.CircleImageSecondWelcome
import com.example.planify.components.CircleImageWelcome
import com.example.planify.components.RadioButtonGroup
import com.example.planify.components.backgroundScreen
import com.example.planify.components.roundedContainerScreen
import com.example.planify.components.textNext
import com.example.planify.components.textSecondWelcomePlanify
import com.example.planify.components.textWelcomePlanify


@Composable
fun welcomePlanifyScreen(
    modifier: Modifier,
    navigateToSecondWelcome: () -> Unit,
    viewModel: welcomePlanifyViewModel = viewModel()
) {
    val currentStep by viewModel.currentStep
    backgroundScreen{
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.size(116.dp))
            when (currentStep) {
                1 -> {
                    textWelcomePlanify()
                }

                2 -> {
                    textSecondWelcomePlanify()
                }
            }
            Spacer(modifier = Modifier.size(116.dp))
            Body(currentStep = currentStep, onStepChange = { viewModel.setStep(it) })
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

