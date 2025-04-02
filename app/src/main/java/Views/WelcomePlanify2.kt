package Views
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.layout.*
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil.*


@Composable
fun WelcomePlanify2(modifier: Modifier = Modifier) {
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

        ) {
            Box{
                Column(
                ){
                    CoilImage(
                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/dra8e2dz.png"},
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                        modifier = Modifier
                            .offset(x = 290.dp, y = 22.dp) //Posicionamiento de la imagen superior derecha (Circular)
                            .width(120.dp)
                            .height(120.dp)
                    )
                }
            }

            Text("¿Estás listo para tomar el control de tus finanzas?",
                color = Color(0xFFFDF5F5),
                fontSize = 32.sp, //Tamano del texto
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 10.dp,bottom = 110.dp,start = 33.dp,end = 33.dp,)
                    .offset(y = 50.dp)
            )

            //Columna que contiene la imagen y el texto
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,))
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF1B1A55),
                        shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,)
                    )
                    .padding(vertical = 68.dp,horizontal = 64.dp,)
            ){
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/q3bju05x.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .padding(bottom = 59.dp,)
                        .width(283.dp)
                        .height(289.dp)
                )
                Text("Siguiente",
                    color = Color(0xFFFDF5F5),
                    fontSize = 32.sp,
                    modifier = Modifier
                        .padding(bottom = 15.dp,)
                )
                Row(
                ){
                    CoilImage(
                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/eyvq3zsw.png"},
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                        modifier = Modifier
                            .padding(end = 17.dp,)
                            .width(26.dp)
                            .height(25.dp)
                    )
                    CoilImage(
                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/8pq5mhgr.png"},
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                        modifier = Modifier
                            .width(26.dp)
                            .height(25.dp)
                    )
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LaunchPreview() {
//    WelcomePlanify2()
//}