package com.gabrielfranconascimen.designsystem.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.texts.FAText

@Composable
fun FACard(
    modifier: Modifier = Modifier,
    borderShape: Shape = RoundedCornerShape(Dimens.roundButton),
    borderStroke: BorderStroke? = BorderStroke(
        Dimens.borderStroke,
        Colors.borderGray
    ),
    cardColors: CardColors = CardDefaults.cardColors(
        containerColor = Colors.backgroundCard,
        contentColor = Colors.text
    ),
    elevation: CardElevation = CardDefaults.cardElevation(),
    contentPadding: PaddingValues = PaddingValues(Dimens.mediumPadding),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .clip(borderShape)
            .clickable(
                enabled = onClick != null,
                indication = rememberRipple(radius = Dp.Infinity),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick?.invoke() }
            ),
        shape = borderShape,
        border = borderStroke,
        elevation = elevation,
        colors = cardColors
    ) {
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            content()
        }
    }
}

@Composable
@Preview
private fun FACardPreview() {
    FATheme {
        FACard {
            Column {
                FAText(text = "title")
                FAText(text = "Subtitle")
            }
        }
    }
}