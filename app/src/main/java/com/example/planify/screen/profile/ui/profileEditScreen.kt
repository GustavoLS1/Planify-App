package com.example.planify.screen.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planify.R
import com.example.planify.components.textNombreProfile
import androidx.compose.runtime.getValue
import com.example.planify.components.Email
import com.example.planify.components.Name
import com.example.planify.components.Number
import com.example.planify.components.textEmail
import com.example.planify.components.textNumberProfile

@Composable
fun ProfileEditScreen(onBackClick: () -> Unit,
                      modifier: Modifier,
                      onCancelClick: () -> Unit,
                      viewModel: profileViewModel = viewModel()) {
    val darkBlue = Color(0xFF0D0D4B)
    val purpleBlue = Color(0xFF1D1F6F)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(darkBlue)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Encabezado
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp)
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Configura tu perfil",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(32.dp)) // Baja la parte ovalada

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        purpleBlue,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 40.dp, bottom = 24.dp)
                ) {
                    val name by viewModel.name
                    val number by viewModel.number
                    val email by viewModel.email
                    // Imagen de perfil superpuesta
                    Box(
                        modifier = Modifier.offset(y = -80.dp) // Menos desplazamiento
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start
                    ){
                        textNombreProfile()
                        Spacer(modifier = Modifier.height(9.dp))
                        Name(name) {
                            viewModel.onProfileChange(
                                name = it,
                                number = number,
                                email = email
                            )
                        }
                        Spacer(modifier = Modifier.height(38.dp))
                        textNumberProfile()
                        Spacer(modifier = Modifier.height(9.dp))
                        Number(number) {
                            viewModel.onProfileChange(
                                name = name,
                                number = it,
                                email = email
                            )
                        }
                        Spacer(modifier = Modifier.height(38.dp))
                        textEmail()
                        Spacer(modifier = Modifier.height(9.dp))
                        Email(email) {
                            viewModel.onProfileChange(
                                name = name,
                                number = number,
                                email = it
                            )
                        }

                    }
                    // Campos

                    Spacer(modifier = Modifier.height(38.dp))

                    // Botones
                    Button(
                        onClick = { /* Guardar */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBDBDFF))
                    ) {
                        Text("Guardar", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onCancelClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D2D8A))
                    ) {
                        Text("Cancelar", color = Color.White)
                    }
                }
            }
        }
    }
}
