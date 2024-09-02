package com.gabrielfranconascimen.designsystem.components.texts

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
import com.gabrielfranconascimen.designsystem.components.texts.models.FATextFieldEntity

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    entity: FATextFieldEntity,
    focusRequest: FocusRequester? = null,
    onValueChange: (String) -> Unit
) {
    var showPassword by remember { mutableStateOf(false) }

    FATextField(
        modifier = modifier.apply {
            focusRequest?.let {
                this.focusRequester(it)
            }
        },
        entity = entity,
        singleLine = true,
        onValueChange = onValueChange,
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