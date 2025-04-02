package Views
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
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.coil.*
@Composable
fun WelcomePlanify1(modifier: Modifier = Modifier) {
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
            Column(

                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .padding(bottom = 91.dp,)
                    .fillMaxWidth()
            ){
                Box{
                    Column(
                    ){
                        CoilImage(
                            imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/dra8e2dz.png"},
                            imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                            modifier = Modifier
                                .offset(x = 220.dp, y = 22.dp)
                                .width(120.dp)
                                .height(120.dp)
                        )
                    }
                    Text("Bienvenido a nuestro administrador de gastos ",
                        color = Color(0xFFACADD9),
                        fontSize = 32.sp, //Tamano del texto
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .offset(x = -38.dp, y = 155.dp)
                            .align(Alignment.BottomEnd)
                            .width(337.dp)
                    )
                }
            }
            //Columna que contiene la imagen y el texto
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .offset(x = 0.dp, y = 140.dp)
                    .clip(shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,))
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF1B1A55),
                        shape = RoundedCornerShape(topStart = 65.dp,topEnd = 65.dp,)
                    )
                    .padding(vertical = 68.dp,horizontal = 64.dp,)
            ){
                //Imagen del centro
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/r9nca0ua.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = Modifier
                        .offset(x = 0.dp, y = 0.dp)
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
                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/9mh5rkyv.png"},
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                        modifier = Modifier
                            .padding(end = 17.dp,)
                            .width(26.dp)
                            .height(25.dp)
                    )
                    CoilImage(
                        imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/fta22289.png"},
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

@Preview(showBackground = true)
@Composable
fun LaunchPreview() {
    WelcomePlanify1()
}