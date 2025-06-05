package com.example.planify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.ui.theme.SecondColor
import com.example.planify.ui.theme.ThirdColor

@Composable
fun CategoriaItem(nombre: String, onEditClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(ThirdColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(nombre, color = Color.White, fontSize = 20.sp, fontFamily = letterStyles.AmaranthFont)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { onEditClick(nombre) },
            colors = ButtonDefaults.buttonColors(containerColor = SecondColor)
        ) {
            Text("Edit", color = Color.White, fontSize = 15.sp, fontFamily = letterStyles.AmaranthFont)
        }
    }
}
