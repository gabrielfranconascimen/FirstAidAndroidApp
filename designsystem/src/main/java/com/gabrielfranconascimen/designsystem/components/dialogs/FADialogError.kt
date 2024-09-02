package com.gabrielfranconascimen.designsystem.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.components.texts.FAText

@Composable
fun FADialogError (
    message: String,
    onAction: () -> Unit
) {
    Dialog(onDismissRequest = {  }) {
        Column(modifier = Modifier
            .fillMaxWidth(0.85f)
            .background(
                color = Colors.backgroundCard.copy(alpha = 0.9f),
                shape = RoundedCornerShape(Dimens.roundButton)
            )
            .padding(
                top = Dimens.mediumPadding,
                end = Dimens.mediumPadding,
                start = Dimens.mediumPadding
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FAText(
                text = "Atenção",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(Dimens.smallPadding))
            FAText(
                text = message,
                color = Colors.text
            )
            Spacer(modifier = Modifier.height(Dimens.mediumPadding))
            HorizontalDivider()
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onAction
            ) {
                FAText(text = "Ok")
            }
        }
    }
}