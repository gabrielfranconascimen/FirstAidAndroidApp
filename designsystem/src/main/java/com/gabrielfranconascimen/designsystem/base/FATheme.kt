package com.gabrielfranconascimen.designsystem.base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun FATheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkFAColor else LightFAColor
    val dimension = DefaultDimensions

    ProvideDimens(dimension = dimension) {
        ProvideColors(colors = colors) {
            MaterialTheme(
                typography = Typography(),
                shapes = Shapes(),
                content = content
            )
        }
    }
}

object FATheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val colors: FAColors
        @Composable
        get() = LocalAppColors.current
}

val Dimens: Dimensions
    @Composable
    get() = FATheme.dimens

val Colors: FAColors
    @Composable
    get() = FATheme.colors


@Composable
fun ProvideColors(
    colors: FAColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors.copy() }
    colorPalette.update(colors)
    CompositionLocalProvider( LocalAppColors provides colorPalette, content)
}

@Composable
fun ProvideDimens(
    dimension: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimension }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content)
}

private val LocalAppColors = staticCompositionLocalOf<FAColors> {
    error("No FAColorScheme provided")
}

private val LocalAppDimens = staticCompositionLocalOf { DefaultDimensions }