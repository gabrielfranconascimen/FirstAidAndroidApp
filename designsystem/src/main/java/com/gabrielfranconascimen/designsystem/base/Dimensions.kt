package com.gabrielfranconascimen.designsystem.base

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
class Dimensions(
    val extraLargPadding: Dp,
    val largePadding: Dp,
    val mediumPadding: Dp,
    val smallPadding: Dp,
    val roundButton: Dp,
    val borderStroke: Dp,
    val iconSize: Dp
)

val DefaultDimensions = Dimensions(
    extraLargPadding = 48.dp,
    largePadding = 24.dp,
    mediumPadding = 12.dp,
    smallPadding = 6.dp,
    roundButton = 12.dp,
    borderStroke = 1.dp,
    iconSize = 16.dp
)