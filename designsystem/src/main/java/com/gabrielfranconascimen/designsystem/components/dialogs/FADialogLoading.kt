package com.gabrielfranconascimen.designsystem.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme

@Composable
fun FADialogLoading() {
    Dialog(onDismissRequest = { }) {
        Box(
            modifier = Modifier
                .background(
                    color = Colors.backgroundPrimary,
                    shape = RoundedCornerShape(Dimens.roundButton)
                )
                .padding(Dimens.mediumPadding)
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
@Preview
private fun FADialogLoadingPreview() {
    FATheme {
        FADialogLoading()
    }
}