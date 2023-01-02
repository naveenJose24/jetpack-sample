package com.example.myjetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var fontFamily = FontFamily(Font(R.font.prosto_one_regular, FontWeight.Thin))
        setContent {

            Row() {
                Box(modifier = Modifier.width(width = 150.dp)) {
                    ImageCard(
                        title = "Sample Title",
                        description = "Sample Description",
                        painter = painterResource(id = R.drawable.rectangle_27),
                        modifier = Modifier.padding(16.dp)
                    )
                }
                Column() {
                    val color = remember {
                        mutableStateOf(Color.Yellow)
                    }
                    Box(

                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = color.value),

                        )
                    {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Blue)) {
                                    append("Hello\n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    )
                                ) {
                                    append("World\n")
                                }
                                append("Compose")

                            }
                        )
                    }
                    ColorBox {
                        print(color.value.toString())
                        color.value =it }

                }
            }


        }
    }
}


@Composable
fun ImageCard(
    title: String,
    description: String,
    painter: Painter,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp)

    ) {
        Box(modifier = Modifier.height(height = 200.dp)) {
            Image(
                painter = painter, contentDescription = description,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ), startY = 300f
                        )
                    )

            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title, style = TextStyle(
                        color = Color.Blue, fontSize = 16.sp, textAlign = TextAlign.Center
                    )
                )
            }


        }
    }
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,

    ) {


    Box(
        modifier = modifier
            .width(width = 100.dp)
            .height(height = 50.dp)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                    )
                )
            }
            .border(color = Color.Blue, width = 2.dp)) {
        Text(text = "Click")
    }

}