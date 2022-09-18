package org.lynxz.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lynxz.compose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.background(Color.Green)) {
        Text(
            text = "Hello $name!111112456", modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
        )

        Box(contentAlignment = Alignment.Center, modifier = Modifier.align(Alignment.End)) {
            Image(
                painter = painterResource(id = R.mipmap.lynxz),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .border(2.dp, Color.White)
                    .size(200.dp)
//                .background(Color.White)
                    .clip(CircleShape)
//                .padding(10.dp)
//                .border(1.dp, Color.White)
            )

            Text(
                text = "Lynxz",
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier
                    .border(1.dp, Color.White)
//                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(0.5f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Greeting("Android")
    }
}