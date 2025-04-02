package Views

import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil.*


@Composable
fun Launch2(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(
                    color = Color(0xFF070F2B),
                )
                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .padding(bottom = 31.dp,start = 110.dp,)
            ){
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .padding(bottom = 120.dp,)
                ){
                    Box{
                        Column(
                        ){
                            CoilImage(
                                imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/av62mm7z.png"},
                                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                modifier = Modifier
                                    .offset(x = 200.dp, y = 20.dp)
                                    .width(100.dp)
                                    .height(100.dp)
                            )
                        }
                        CoilImage( //PlanifyLogo
                            imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/9aa3vc2o.png"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .offset(x = -50.dp, y = 190.dp)
                                .align(Alignment.BottomEnd)
                                .padding(bottom = 50.dp)
                                .width(330.dp)
                                .height(112.dp)
                        )
                    }
                }
                CoilImage( //LogoCentral
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/1frq7vnm.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .width(192.dp)
                        .height(198.dp)
                )
            }
            //Texto Central
            Text("Bienvenido a Planify. Gestiona tus finanzas de forma fácil y eficiente. Inicia sesión y toma el control de tu dinero.",
                color = Color(0xFFFDF5F5),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp,start = 74.dp,end = 63.dp,)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 25.dp,)
                    .fillMaxWidth()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    OutlinedButton( //Inicio de sesion
                        onClick = { println("Pressed!") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .padding(bottom = 7.dp,)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(
                                color = Color(0xFFACADD9),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ){
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp,horizontal = 50.dp,)
                        ){
                            Text("Iniciar Sesión",
                                color = Color(0xFF070F2B),
                                fontSize = 20.sp,
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = { println("Pressed!") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .padding(bottom = 7.dp,)
                            .border(
                                width = 1.dp,
                                color = Color(0xFF8E918F),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(vertical = 13.dp,horizontal = 9.dp,)
                        ){
                            CoilImage(
                                imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/clq9w50r.png"},
                                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                                modifier = Modifier
                                    .padding(end = 10.dp,)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .width(18.dp)
                                    .height(18.dp)
                            )
                            Text("Inicie sesión con Google",
                                color = Color(0xFF070F2B),
                                fontSize = 16.sp,
                            )
                        }
                    }
                    OutlinedButton(
                        onClick = { println("Pressed!") },
                        border = BorderStroke(0.dp, Color.Transparent),
                        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(
                                color = Color(0xFF292A86),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ){
                        Column(
                            modifier = Modifier
                                .padding(vertical = 10.dp,horizontal = 60.dp,)
                        ){
                            Text("Registrarse",
                                color = Color(0xFFFDF4F4),
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
            }
            CoilImage(
                imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/77xu5qul.png"},
                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Launch2Preview() {
//	Launch2()
//}