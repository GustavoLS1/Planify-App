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
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil.*
@Composable
fun Launch1(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .weight(1f)
                .background(
                    color = Color(0xFF070F2B),
                )
                .verticalScroll(rememberScrollState())
        ){
            Column(
                horizontalAlignment = Alignment.End,
                modifier = modifier
                    .padding(bottom = 190.dp,) // Tamaño máximo pantalla
                    .fillMaxWidth()
            ){
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/1uq1y1uw.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = modifier
                        .width(100.dp)
                        .height(100.dp)
                )
            }
            Column( //Column Principal
                modifier = modifier
                    .offset(x = 5.dp, y = (-50).dp)
                    .padding(bottom = 146.dp,start = 41.dp,end = 41.dp, top = 0.dp,)

                    .fillMaxWidth()

            ){
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/3qp7w53h.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = modifier
                        .height(112.dp)
                        .fillMaxWidth()
                )
                CoilImage(
                    imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/hdixymz4.png"},
                    imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                    modifier = modifier
                        .padding(horizontal = 28.dp,)
                        .height(272.dp)
                        .fillMaxWidth()
                )
            }
            CoilImage(
                imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/mIHtVzcCAR/qzn2uqj4.png"},
                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                modifier = modifier
                    .width(100.dp)
                    .height(100.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LaunchPreview() {
//    Launch1()
//}