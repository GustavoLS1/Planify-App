package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.R

@Composable
fun iconProfile(){
    Image(
        painter = painterResource(id = R.drawable.icon_profile),
        contentDescription = "Icon Profile",
        modifier = Modifier.size(45.dp, 38.dp))

}

@Composable
fun iconNotifications(){
    Image(
        painter = painterResource(id = R.drawable.icon_notifications),
        contentDescription = "Icon notifications",
        modifier = Modifier.size(45.dp, 38.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconSearch(){
    Image(
        painter = painterResource(id = R.drawable.icon_search),
        contentDescription = "Icon search",
        modifier = Modifier.size(45.dp, 38.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconStatistics(){
    Image(
        painter = painterResource(id = R.drawable.icon_statistics),
        contentDescription = "Icon statistics",
        modifier = Modifier.size(45.dp, 38.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconHome(){
    Image(
        painter = painterResource(id = R.drawable.icon_home),
        contentDescription = "Icon home",
        modifier = Modifier.size(36.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun iconCategory(){
    Image(
        painter = painterResource(id = R.drawable.icon_category),
        contentDescription = "Icon category",
        modifier = Modifier.size(36.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun iconNoteBook(){
    Image(
        painter = painterResource(id = R.drawable.icon_notebook),
        contentDescription = "Icon notebook",
        modifier = Modifier.size(36.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun iconSettings(){
    Image(
        painter = painterResource(id = R.drawable.icon_settings),
        contentDescription = "Icon settings",
        modifier = Modifier.size(36.dp),
        contentScale = ContentScale.Fit
    )
}