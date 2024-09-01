package com.gabrielfranconascimen.designsystem.components.texts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.gabrielfranconascimen.designsystem.R


@Composable
fun PasswordTextField(
    focusRequest: FocusRequester?,
    hasError: Boolean,
    value: String,
    onUpdateValue: (String) -> Unit
) {
    var showPassword by remember { mutableStateOf(false) }
    val modifier = Modifier
        .fillMaxWidth()
        .apply {
            focusRequest?.let {
                this.focusRequester(it)
            }
        }
    FATextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        isError = hasError,
        onValueChange = onUpdateValue,
        hint = stringResource(id = R.string.sign_in_user_password_hint),
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                val icon = if (showPassword) R.drawable.ic_visibility_24 else R.drawable.ic_visibility_off_24
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(id = R.string.icon_visibility_description),
                    tint = Color.Gray
                )
            }
        }
    )
}