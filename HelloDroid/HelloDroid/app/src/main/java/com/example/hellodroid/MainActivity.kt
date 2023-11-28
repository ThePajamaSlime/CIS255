package com.example.hellodroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellodroid.ui.theme.HelloDroidTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloDroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingImage()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.web)

    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = "void star LLC",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
        )
        Text(
            text = "Khamanei Ainsworth",
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "CEO",
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "313-ABC-YZZY",
            fontWeight = FontWeight.Light,
            fontSize = 20.sp
        )
        Row(modifier.align(alignment = Alignment.End)) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(15.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            Text(
                text = "voidst.ar",
                fontSize = 20.sp,

            )
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.wordart)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.background(Color.Gray)) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 250.dp, height = 90.dp)
                .padding(bottom = 0.dp)
        )
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloDroidTheme {


       // Greeting("Android")
        GreetingImage()
    }
}
