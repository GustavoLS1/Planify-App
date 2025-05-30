package com.example.planify.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.letterStyles
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor
import com.example.planify.ui.theme.ThirdColor

@Composable
fun Header(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .background(ThirdColor)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
            Text(
                text = "Libreta",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Presupuesto", color = Color.White, fontFamily = letterStyles.AmaranthFont)
            Text(
                "$500.000",
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = letterStyles.AmaranthFont
            )
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun SummaryIncome(
    income: Float = 500000f,
    presupuestado: Float = 1000000f
) {
    val progreso = if (presupuestado == 0f) 0f else (income / presupuestado).coerceIn(0f, 1f)

    val colorProgreso = if (income.toInt() == 0) Color.Transparent else Color(0xFF00FF00)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2A2F9C))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Monto", color = Color.White, fontSize = 15.sp, fontFamily = letterStyles.AmaranthFont)
            Text(
                "$${String.format("%,.0f", income)}",
                color = Color(0xFF00FF00),
                fontSize = 15.sp,
                fontFamily = letterStyles.AmaranthFont
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Barra de progreso personalizada
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progreso)
                    .fillMaxHeight()
                    .background(colorProgreso)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Presupuestado $${String.format("%,.0f", presupuestado)}", color = Color.White, fontSize = 12.sp, fontFamily = letterStyles.AmaranthFont)
        }
    }
}

@Composable
fun MetasList() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        MetaItem("Moto", 500, 1000)
        MetaItem("Inversión", 0, 0)
        MetaItem("Recompensa", 0, 0)
    }
}

@Composable
fun MetaItem(nombre: String, actual: Int, total: Int) {
    val progreso = if (total > 0) (actual.toFloat() / total).coerceIn(0f, 1f) else 0f
    val colorProgreso = if (actual == 0) Color.Transparent else Color(0xFF00FF00)

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1D1F6F)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(nombre, color = Color.White, fontFamily = letterStyles.AmaranthFont, fontSize = 20.sp)
                Text(
                    "$${String.format("%,.0f", actual.toFloat())}",
                    color = Color(0xFF00FF00),
                    fontFamily = letterStyles.AmaranthFont,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Barra personalizada continua
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progreso)
                        .fillMaxHeight()
                        .background(colorProgreso)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "$${String.format("%,.0f", total.toFloat())}",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = letterStyles.AmaranthFont
                )
            }
        }
    }
}

@Composable
fun FloatingActionMenu(
    expanded: Boolean,
    onExpandedChange: () -> Unit
) {
    // Capa de fondo difuminada azul oscuro cuando está expandido
    if (expanded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x991D1F6F)) // Azul con opacidad (~60%)
                .clickable { onExpandedChange() } // Cierra al hacer clic fuera
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(horizontalAlignment = Alignment.End) {
            if (expanded) {

                // Botón: Meta de ahorro
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(PrimaryColor, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .clickable { /* Acción Meta */ },
                ) {
                    Text("Meta de ahorro", color = Color.White, fontFamily = letterStyles.AmaranthFont)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Default.Savings, contentDescription = "Meta", tint = Color.White)
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            FloatingActionButton(onClick = onExpandedChange, containerColor = SecondColor) {
                Icon(Icons.Default.Add, contentDescription = "Más", tint = Color.White)
            }
        }
    }
}