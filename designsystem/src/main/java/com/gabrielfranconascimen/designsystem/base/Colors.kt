package com.gabrielfranconascimen.designsystem.base

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

val redError = Color(0xFFE56669)
val mediumLightGray = Color(0xFFd9d9d9)
val extraLightGray = Color(0xFFf2f2f2)

val LightFAColor = FAColors(
    primary = lightColorScheme().primary,
    secondary = lightColorScheme().secondary,
    backgroundPrimary = lightColorScheme().onPrimary,
    backgroundSecondary = lightColorScheme().onSecondary,
    backgroundCard = extraLightGray,
    text = Color.Black,
    error = redError,
    borderGray = Color.Gray,
    buttonText = Color.DarkGray
)

val DarkFAColor = FAColors(
    primary = darkColorScheme().primary,
    secondary = darkColorScheme().secondary,
    backgroundPrimary = darkColorScheme().onPrimary,
    backgroundSecondary = darkColorScheme().onSecondary,
    backgroundCard = mediumLightGray,
    error = redError,
    text = Color.White,
    borderGray = Color.Gray,
    buttonText = Color.LightGray
)

@Stable
class FAColors(
    primary: Color,
    secondary: Color,
    backgroundPrimary: Color,
    backgroundSecondary: Color,
    backgroundCard: Color,
    error: Color,
    text: Color,
    buttonText: Color,
    borderGray: Color,
    illustrationColors: IllustrationColors = IllustrationColors
) {
    var primary = mutableStateOf(primary).value
        private set
    var secondary = mutableStateOf(secondary).value
        private set
    var backgroundPrimary = mutableStateOf(backgroundPrimary).value
        private set
    var backgroundSecondary = mutableStateOf(backgroundSecondary).value
        private set
    var backgroundCard = mutableStateOf(backgroundCard).value
        private set
    var backgroundOverlayPrimary = mutableStateOf(error).value
        private set
    var buttonText = mutableStateOf(buttonText).value
        private set
    var text = mutableStateOf(text).value
        private set
    var borderGray = mutableStateOf(borderGray).value
        private set
    var illustrationColors = mutableStateOf(illustrationColors).value
        private set

    fun update(other: FAColors) {
        primary = other.primary
        secondary = other.secondary
        backgroundPrimary = other.backgroundPrimary
        backgroundSecondary = other.backgroundSecondary
        backgroundOverlayPrimary = other.backgroundOverlayPrimary
        backgroundCard = other.backgroundCard
        buttonText = other.buttonText
        text = other.text
        borderGray = other.borderGray
        illustrationColors = other.illustrationColors
    }

    fun copy(): FAColors = FAColors(
        primary = primary,
        secondary = secondary,
        backgroundPrimary = backgroundPrimary,
        backgroundSecondary = backgroundSecondary,
        backgroundCard = backgroundCard,
        error = backgroundOverlayPrimary,
        buttonText = buttonText,
        text = text,
        borderGray = borderGray,
        illustrationColors = illustrationColors
    )
}

/**
 * A Material [ColorScheme] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colorScheme] in preference to [FATheme.colors].
 */
fun debugColors(debugColor: Color) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
    surfaceBright = debugColor,
    surfaceDim = debugColor,
    surfaceContainer = debugColor,
    surfaceContainerHigh = debugColor,
    surfaceContainerHighest = debugColor,
    surfaceContainerLow = debugColor,
    surfaceContainerLowest = debugColor
)