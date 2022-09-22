package org.lynxz.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.lynxz.compose.ui.theme.pink100
import org.lynxz.compose.ui.theme.pink900

// https://www.bilibili.com/video/BV1Y341157ym
// 扔物线 围观app 的布局重写


@Composable
fun WeiGuanPage() {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(pink100)
        ) {
            WGTopBar()
            WGSearchBar()
            WGNameBar()
            WGLovesArea()
            WGPlaceArea()
        }
        WGNaviBar()
    }
}

// TA去过
@Composable
fun WGPlaceArea() {
    Column(
        modifier = Modifier
            .padding(24.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Text(text = "TA去过", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(0.dp, 10.dp)
        ) {
            itemsIndexed(listOf(1, 2, 3)) { index, name ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Yellow)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avator),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Column(modifier = Modifier.padding(10.dp, 2.dp)) {
                        Text(text = "5分钟前", fontSize = 15.sp, color = Color.LightGray)
                        Text(
                            text = "Lynxz的办公室",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "福建", fontSize = 15.sp, color = Color.LightGray)
                    }
                }
            }
        }

    }
}


// TA爱的
@Composable
fun WGLovesArea() {
    val indexList = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    Column {
        Row(
            modifier = Modifier
                .padding(36.dp, 12.dp)
                .fillMaxWidth()
        ) {
            Text(text = "TA爱的", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "查看全部", fontSize = 15.sp, color = Color.Gray)
        }

        LazyRow(
            contentPadding = PaddingValues(12.dp, 0.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(indexList) { index, name ->
                LoveItem(
                    imgId = R.drawable.avator,
                    contentDescription = "avator$index",
                    title = "avatar$index",
                    subTitle = "subTitle$index",
                    rating = index.toFloat()
                )
            }
        }
    }
}

// TA爱的  元素item
@Composable
fun LoveItem(
    @DrawableRes imgId: Int, contentDescription: String?,
    title: String, subTitle: String, rating: Float
) {
    Column(modifier = Modifier.padding(6.dp)) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .width(200.dp)
                .padding(end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = subTitle, fontSize = 15.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .padding(0.dp),
                color = Color(0xabffffffff)
            ) {
                Row {
                    Icon(Icons.Outlined.Star, contentDescription = null)
                    Text(text = "$rating")
                }
            }
        }
    }
}

// 分类栏
@Composable
fun WGNameBar() {
    val names =
        listOf("Kotlin", "c++", "python", "Java", "C#", "Kotlin", "c++", "python", "Java", "C#")
    var selected by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier
            .padding(12.dp, 4.dp),
        contentPadding = PaddingValues(12.dp, 0.dp)
    ) {
        itemsIndexed(names) { index, name ->
            Column(
                modifier = Modifier
                    .padding(12.dp, 4.dp)
                    .width(IntrinsicSize.Max)
            ) {
                Text(
                    text = name,
                    fontSize = 15.sp,
                    color = if (index == selected) Color.Red else Color.Gray
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .height(2.dp)
                        .clip(RoundedCornerShape(1.dp))
                        .background(if (index == selected) Color.Red else Color.Transparent)
                )
            }
        }
    }
}

// 顶部搜索调
@Composable
fun WGSearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 4.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var searchText by remember {
            mutableStateOf("")
        }

        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .padding(start = 24.dp)
                .weight(1f)
        ) {
            if (searchText.isEmpty()) {
                Text(text = "搜搜看？", color = Color(0xffb4b4b4), fontSize = 15.sp)
            }
            it()
        }

        Box(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xfffa9e51))
        ) {
            IconButton(onClick = { println("click search button, input:${searchText}") }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "搜索",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )

            }
        }
    }
}

// 顶部姓名信息
@Composable
fun WGTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(28.dp, 28.dp, 28.dp, 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avator),
            contentDescription = "头像",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(120.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 14.dp)
                .weight(1f)
        ) {
            Text(text = "欢迎回来", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Lynxz", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Surface(modifier = Modifier.clip(RoundedCornerShape(10.dp)), color = pink900) {
            Image(
                painter = painterResource(id = R.mipmap.notification),
                contentDescription = "通知",
                modifier = Modifier
                    .padding(10.dp)
                    .size(32.dp)
            )
        }
    }
}

@Composable
fun WGNaviBar() {
    Row(
        modifier = Modifier
            .height(84.dp)
            .padding(16.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NaviItem(Icons.Filled.Home, "home", Color.Yellow)
        NaviItem(Icons.Filled.Favorite, "Favorite", Color.Gray)
        NaviItem(Icons.Filled.DateRange, "DateRange", Color.Gray)
        NaviItem(Icons.Filled.Search, "Search", Color.Gray)
    }
}

@Composable
fun RowScope.NaviItem(@DrawableRes iconRes: Int, description: String) {
    Icon(painter = painterResource(id = iconRes), contentDescription = description)
}

@Composable
fun RowScope.NaviItem(imageVector: ImageVector, description: String, tint: Color) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
        shape = RectangleShape,
        colors = ButtonDefaults.outlinedButtonColors()
    ) {
        Icon(imageVector = imageVector, contentDescription = description, tint = tint)
    }
}