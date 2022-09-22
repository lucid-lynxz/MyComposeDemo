package org.lynxz.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    SearchBar()
//                    WelcomePage()
                    WeiGuanPage()
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    val searchTip = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD3D3D3))
            .padding(6.dp, 2.dp)
    ) {
        BasicTextField(value = searchTip.value,
            // 设置单行输入， 但仅仅使用 maxLines=1和singleLine=true， 依然可以输入回车， 因此通过截取实现
            onValueChange = { searchTip.value = it.replace("\n", "") },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp, 5.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(10.dp, 4.dp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null) // 搜索图标
                    Spacer(modifier = Modifier.width(10.dp))

                    Box(modifier = Modifier.weight(1f, fill = true)) {
                        innerTextField() // 必须调用
                    }

                    // 右侧的关闭按钮，在有输入值的时候显示
                    // 需要有点击时间， 因此使用 IconButton
                    if (searchTip.value.isNotEmpty()) {
                        IconButton(onClick = {
                            searchTip.value = ""
                        }, modifier = Modifier.size(20.dp)) {
                            Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                        }
                    }
                }
            }
        )
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