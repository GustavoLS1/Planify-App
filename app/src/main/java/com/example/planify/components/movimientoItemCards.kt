package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.R
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


@Composable
fun incomeCard(
    titulo: String,
    monto: String,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .size(90.dp, 90.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.card_recibos),
            contentDescription = "recibos",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = titulo,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,

                )
            Text(
                text = formatCurrencyCustom(monto),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,

                )
        }

    }

}

@Composable
fun expenseCard(
    titulo: String,
    monto: String,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .size(90.dp, 90.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.card_gastos),
            contentDescription = "recibos",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = titulo,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,

                )
            Text(
                text = formatCurrencyCustom(monto),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,

                )
        }

    }

}

fun formatCurrencyCustom(amount: String): String {
    return try {
        val number = amount.toDouble()

        when {
            number >= 1_000_000_000_000 -> String.format("$%.1f trillón", number / 1_000_000_000_000)
            number >= 1_000_000_000 -> String.format("$%.1f billón", number / 1_000_000_000)
            number >= 1_000_000 -> {
                val millones = number / 1_000_000
                val decimales = (number % 1_000_000) / 100_000
                "$${millones.toInt()}'${decimales.toInt()} millón"
            }
            number >= 1_000 -> {
                val formatter = DecimalFormat("#,###", DecimalFormatSymbols().apply {
                    groupingSeparator = '.'
                })
                "$${formatter.format(number)}"
            }
            else -> "$${number.toInt()}"
        }
    } catch (e: Exception) {
        amount // En caso de error, devolver sin modificar
    }
}

