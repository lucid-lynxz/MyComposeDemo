package org.lynxz.compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.lynxz.compose.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(R.font.nunitosans_bold, FontWeight.Bold)
)

val h1 = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp
)

val h2 = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    letterSpacing = 0.15.sp
)

val subtitle1 = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Light,
    fontSize = 16.sp,
)

val body1 = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Light,
    fontSize = 14.sp
)

val body2 = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Light,
    fontSize = 12.sp
)

val button = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    letterSpacing = 1.sp
)

val caption = TextStyle(
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp
)

