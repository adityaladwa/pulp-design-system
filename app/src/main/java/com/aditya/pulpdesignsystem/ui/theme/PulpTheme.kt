package com.aditya.pulpdesignsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class PulpColors(
    val content: Color,
    val component: Color,
    val background: List<Color>,
)

@Immutable
data class PulpTypography(
    val body: TextStyle,
    val title: TextStyle
)

@Immutable
data class PulpElevation(
    val default: Dp,
    val pressed: Dp
)

val LocalPulpColors = staticCompositionLocalOf {
    PulpColors(
        content = Color.Unspecified,
        component = Color.Unspecified,
        background = emptyList(),
    )
}

val LocalPulpTypography = staticCompositionLocalOf {
    PulpTypography(
        body = TextStyle.Default,
        title = TextStyle.Default
    )
}

val LocalPulpElevation = staticCompositionLocalOf {
    PulpElevation(
        default = Dp.Unspecified,
        pressed = Dp.Unspecified
    )
}

@Composable
fun PulpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val pulpColors = PulpColors(
        content = Color(0xFFDD0D3C),
        component = Color(0xFFC20029),
        background = listOf(Color.White, Color(0xFFF8BBD0)),
    )

    val pulpTypography = PulpTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 32.sp)
    )

    val pulpElevation = PulpElevation(
        default = 4.dp,
        pressed = 8.dp
    )

    CompositionLocalProvider(
        LocalPulpColors provides pulpColors,
        LocalPulpTypography provides pulpTypography,
        LocalPulpElevation provides pulpElevation,
        content = content
    )
}

object PulpTheme {
    val colors: PulpColors
        @Composable
        get() = LocalPulpColors.current

    val typography: PulpTypography
        @Composable
        get() = LocalPulpTypography.current

    val elevation: PulpElevation
        @Composable
        get() = LocalPulpElevation.current
}