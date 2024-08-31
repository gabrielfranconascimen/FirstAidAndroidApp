package com.gabrielfranconascimen.designsystem.components.texts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.FATheme

@Composable
fun FAText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Colors.text,
    style: TextStyle = MaterialTheme.typography.labelMedium,
    align: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = style,
        textAlign = align
    )
}

@Composable
@Preview
private fun FATextPreview() {
    FATheme {
        FAText(
            modifier = Modifier.fillMaxWidth(),
            text = "Meu Texto"
        )
    }
}