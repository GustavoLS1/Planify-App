package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.R
import com.example.planify.ui.theme.ThirdColor

@Composable
fun BalanceSummaryCard(
    saldoTotal: String,
    ingresos: String,
    gastos: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(ThirdColor, shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Saldo Total", color = Color.White)
                Text(saldoTotal, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.icon_money),
                    contentDescription = "Money Icon",
                    modifier = Modifier.size(40.dp)
                )
            }

            //Parte derecha de la tarjeta
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .width(1.dp)
                    .height(70.dp)
            )

            //Derecha: Ingresos y Gastos
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ){
                SummaryItem(
                    title = "Ingresos",
                    amount = ingresos,
                    backgroundColor = Color(0xFF265E4B)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(color = Color.LightGray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem(
                    title = "Gastos",
                    amount = gastos,
                    backgroundColor = Color(0xFF5D2D2D)

                )
            }
        }
    }
}

@Composable
fun SummaryItem(title: String, amount: String, backgroundColor: Color){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ){
            Text(title, color = Color.White)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(amount, color = Color.White)
    }
}

@Preview
@Composable
fun ViewBalanceSummaryCard() {
    BalanceSummaryCard("50.000", "5000", "5000")
}