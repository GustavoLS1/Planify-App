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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planify.R

@Composable
fun incomeCard(
    titulo: String,
    monto: String
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
                text = monto,
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
    monto: String
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
                text = monto,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,

                )
        }

    }

}



@Preview
@Composable
fun previewMovimientoItemCard() {
    expenseCard(
        titulo = "Recibos",
        monto = "1000"
    )
}