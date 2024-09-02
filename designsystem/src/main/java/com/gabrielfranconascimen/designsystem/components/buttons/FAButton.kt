package com.gabrielfranconascimen.designsystem.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.texts.FAText

@Composable
fun FAButton(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = Colors.buttonText,
        disabledContentColor = Color.Transparent,
        disabledContainerColor = Color.Transparent
    ),
    shape: Shape = RoundedCornerShape(Dimens.roundButton),
    contentPadding: PaddingValues = PaddingValues(
        vertical = Dimens.mediumPadding,
        horizontal = Dimens.largePadding
    ),
    onClick: () -> Unit,
    buttonState: FAButtonState = FAButtonState.Idle,
    content: @Composable () -> Unit
) {

    val backgroundColorAnimated by animateColorAsState(
        if (buttonState.isEnabled() || buttonState.isLoading()) {
            Colors.primary
        } else {
            Color.LightGray
        }
    )

    Box(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .clip(shape)
            .background(backgroundColorAnimated)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    ) {
        if(buttonState.isLoading()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .align(Alignment.Center),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Button(
                modifier = modifier,
                border = border,
                colors = colors,
                shape = shape,
                contentPadding = contentPadding,
                enabled = buttonState.isEnabled(),
                onClick = onClick
            ) {
                content()
            }
        }
    }
}

@Composable
@Preview
private fun FAButtonPreview() {
    FATheme {
        FAButton(onClick = { }) {
            FAText(text = "Click here")
        }
    }
}

enum class FAButtonState {
    Idle, Disable, Loading;

    fun isEnabled(): Boolean {
        return this == Idle
    }

    fun isLoading(): Boolean {
        return this == Loading
    }
}