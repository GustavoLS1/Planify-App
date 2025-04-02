package Views

import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
@Composable
fun Login1(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFF070F2B),
                )
                .verticalScroll(rememberScrollState())
        ){
            Text("Inicia sesión ",
                color = Color(0xFFACADD9),
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(top = 90.dp,bottom = 65.dp, start = 90.dp)
            )
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,))
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF1B1A55),
                        shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,)
                    )
                    .padding(top = 67.dp,bottom = 193.dp,)
            ){
                Text("Correo electrónico:",
                    color = Color(0xFFFDF5F5),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 14.dp,start = 27.dp,)
                )
                Column(
                    modifier = Modifier
                        .padding(bottom = 50.dp,start = 28.dp,end = 28.dp,)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .height(41.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFD9D9D9),
                            shape = RoundedCornerShape(10.dp)
                        )
                ){
                }
                Text("Contraseña:",
                    color = Color(0xFFFDF5F5),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 14.dp,start = 27.dp,)
                )
                Column(
                    modifier = Modifier
                        .padding(bottom = 82.dp,start = 27.dp,end = 27.dp,)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .height(41.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFD9D9D9),
                            shape = RoundedCornerShape(10.dp)
                        )
                ){
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = 28.dp,)
                        .fillMaxWidth()
                ){
                    OutlinedButton(
                        onClick = { println("Pressed!") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(
                                color = Color(0xFFACADD9),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ){
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp,horizontal = 24.dp,)
                        ){
                            Text("Iniciar Sesión",
                                color = Color(0xFF070F2B),
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = 28.dp,)
                        .fillMaxWidth()
                ){
                    OutlinedButton(
                        onClick = { println("Pressed!") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(
                                color = Color(0xFFACADD9),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ){
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp,horizontal = 34.dp,)
                        ){
                            Text("Registrarse",
                                color = Color(0xFF070F2B),
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text("¿Olvidó su correo electronico o contraseña?",
                        color = Color(0xFFACADD9),
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LaunchPreview() {
//    Login1()
//}