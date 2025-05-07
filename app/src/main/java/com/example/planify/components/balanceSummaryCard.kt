package com.example.planify.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planify.R
import com.example.planify.ui.theme.FourthColor
import com.example.planify.ui.theme.PrimaryColor
import com.example.planify.ui.theme.SecondColor
import com.example.planify.ui.theme.ThirdColor
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun BalanceSummaryCard(
    saldoTotal: String,
    ingresos: String,
    gastos: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 16.dp)
            .background(ThirdColor, shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_money),
            contentDescription = "icono de dolar",
            modifier = Modifier
                .offset(x = 27.dp, y = 7.dp)
                .size(65.dp)
                .align(Alignment.BottomStart)
            // Puedes cambiar esto según donde lo necesites
        )
        Text(
            text = "Saldo Total",

            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 27.dp, top = 18.dp)
        )
        Text(
            text = saldoTotal,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 35.dp, bottom = 10.dp)
        )
        VerticalDivider(
            color = FourthColor,
            thickness = 2.dp,
            modifier = Modifier
                .width(2.dp)
                .height(140.dp)
                .offset(x = 123.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .padding(end = 16.dp), // Ajusta si necesitas más separación del borde
            verticalArrangement = Arrangement.Center
        ) {
            // INGRESOS
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(50.dp)
                        .padding(bottom = 1.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ingresos_tag),
                        contentDescription = "Ingresos",
                        modifier = Modifier
                            .height(50.dp)
                            .size(120.dp)
                            .padding(bottom = 1.dp) // Espaciado inferior para separarlo del divider
                    )
                    if (ingresos.isNotEmpty()) {
                        Text(
                            text = ingresos,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.offset(y = 7.dp)
                        )
                    }
                }

            }

            // DIVIDER HORIZONTAL
            HorizontalDivider(
                color = FourthColor,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth(0.6f) // O ajusta según el ancho visual deseado
                    .padding(vertical = 4.dp)
                    .align(Alignment.End) // Opcional si quieres alinearlo a la derecha
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // GASTOS
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 1.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gastos_tag),
                        contentDescription = "Gastos",
                        modifier = Modifier
                            .height(50.dp)
                            .size(120.dp)
                            .padding(top = 1.dp)
                    )
                    if (gastos.isNotEmpty()) {
                        Text(
                            text = gastos,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.offset(y = 7.dp)
                        )
                    }

                }

            }

        }

    }
}


@Preview
@Composable
fun ViewBalanceSummaryCard() {
    BalanceSummaryCard("$50000", "10000", "10000")
}