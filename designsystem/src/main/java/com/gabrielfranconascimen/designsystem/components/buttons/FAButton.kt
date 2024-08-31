package com.gabrielfranconascimen.designsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.texts.FAText

@Composable
fun FAButton(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Colors.primary,
        contentColor = Colors.buttonText
    ),
    shape: Shape = RoundedCornerShape(Dimens.roundButton),
    contentPadding: PaddingValues = PaddingValues(
        vertical = Dimens.mediumPadding,
        horizontal = Dimens.largePadding
    ),
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        border = border,
        colors = colors,
        shape = shape,
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        content()
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