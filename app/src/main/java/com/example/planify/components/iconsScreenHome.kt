package com.example.planify.components

import android.graphics.BlendMode
import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.R
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor

@Composable
fun iconProfile(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_profile),
        contentDescription = "Icon Profile",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() }
    )

}

@Composable
fun iconNotifications(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_notifications),
        contentDescription = "Icon notifications",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconSearch(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_search),
        contentDescription = "Icon search",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun iconStatistics(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(id = R.drawable.icon_statistics),
        contentDescription = "Icon statistics",
        modifier = Modifier
            .size(45.dp, 38.dp)
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SelectableIcon(
    iconRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .size(60.dp)
            .background(
                color = if (isPressed) PrimaryColor else SecondColor,
                shape = RoundedCornerShape(12.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        val success = tryAwaitRelease()
                        isPressed = false
                        if (success) {
                            onClick()
                        }
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id =iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(36.dp),
            contentScale =  ContentScale.Fit,
            alpha = if (isPressed) 0.8f else 1f
        )
    }
}

//Se deja esta parte del codigo por si se necesita re utilizar
//Algo de este apartado en cuanto se toque el tema de navegacion.

//@Composable
//fun iconHome(onClick: () -> Unit = {}) {
//    var isPressed by remember { mutableStateOf(false) }
//
//    Image(
//        painter = painterResource(id = R.drawable.icon_home),
//        contentDescription = "Icon home",
//        modifier = Modifier
//            .size(36.dp)
//            .clickable
//                (
//                onClick = onClick,
//                onClickLabel = "Home"
//            )
//            .pointerInput(Unit){
//                detectTapGestures(
//                    onPress = {
//                        isPressed = true
//                        tryAwaitRelease()
//                        isPressed = false
//                    }
//                )
//            },
//        contentScale = ContentScale.Fit,
//        alpha = if (isPressed) 0.5f else 1.0f)
//
//}
//
//@Composable
//fun iconCategory(onClick: () -> Unit = {}) {
//    Image(
//        painter = painterResource(id = R.drawable.icon_category),
//        contentDescription = "Icon category",
//        modifier = Modifier
//            .size(36.dp)
//            .clickable { onClick() },
//        contentScale = ContentScale.Fit
//    )
//}
//
//@Composable
//fun iconNoteBook(onClick: () -> Unit = {}) {
//    Image(
//        painter = painterResource(id = R.drawable.icon_notebook),
//        contentDescription = "Icon notebook",
//        modifier = Modifier
//            .size(36.dp)
//            .clickable { onClick() },
//        contentScale = ContentScale.Fit
//    )
//}
//
//@Composable
//fun iconSettings(onClick: () -> Unit = {}) {
//    Image(
//        painter = painterResource(id = R.drawable.icon_settings),
//        contentDescription = "Icon settings",
//        modifier = Modifier
//            .size(36.dp)
//            .clickable { onClick() },
//        contentScale = ContentScale.Fit
//    )
//}