package com.gabrielfranconascimen.designsystem.components.texts

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.components.texts.models.FATextFieldEntity

@Composable
fun FATextField(
    modifier: Modifier = Modifier,
    entity: FATextFieldEntity,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    singleLine: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    shape: Shape = RoundedCornerShape(Dimens.roundButton),
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val supportingText: @Composable (() -> Unit)? =
        if (entity.supportingText != null) {
            {
                FAText(
                    text = entity.supportingText,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        } else {
            null
        }

    OutlinedTextField(
        modifier = modifier,
        value = entity.value,
        onValueChange = onValueChange,
        enabled = enabled,
        isError = entity.isError,
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = shape,
        interactionSource = interactionSource,
        trailingIcon = trailingIcon,
        label = { FAText(text = entity.hint) },
        placeholder = { FAText(text = entity.hint,  color = Color.LightGray) },
        supportingText = supportingText,
    )
}