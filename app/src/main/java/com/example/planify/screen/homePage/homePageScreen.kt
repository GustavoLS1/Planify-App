package com.example.planify.screen.homePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.components.SingleChoiceSegmentedButton
import com.example.planify.components.backgroundScreen
import com.example.planify.components.iconHome
import com.example.planify.components.iconNotifications
import com.example.planify.components.iconProfile
import com.example.planify.components.iconSearch
import com.example.planify.components.iconStatistics
import com.example.planify.components.segmentedButtonGroup


@Composable
fun homePageScreen(modifier: Modifier = Modifier) {
    backgroundScreen {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = modifier.fillMaxWidth().padding(35.dp)){
                iconProfile()
                Spacer(modifier = modifier.width(15.dp))
                iconNotifications()
                Spacer(modifier = modifier.width(130.dp))
                iconSearch()
                Spacer(modifier = modifier.width(15.dp))
                iconStatistics()
            }

            Row(modifier = modifier.fillMaxWidth()){
                SingleChoiceSegmentedButton()
            }

        }
    }
}

@Preview
@Composable
fun previewHomePageScreen(){
    homePageScreen(modifier = Modifier)
}

