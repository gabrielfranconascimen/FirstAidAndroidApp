package com.gabrielfranconascimen.designsystem.base

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
    error = redError,
    text = Color.Black,
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
    var error: Color = mutableStateOf(error).value
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
        backgroundCard = other.backgroundCard
        buttonText = other.buttonText
        error = other.error
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
        error = error,
        buttonText = buttonText,
        text = text,
        borderGray = borderGray,
        illustrationColors = illustrationColors
    )
}