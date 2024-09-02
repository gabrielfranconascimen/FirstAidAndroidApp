package com.gabrielfranconascimen.designsystem.components.texts.models

data class FATextFieldEntity(
    val value: String,
    val supportingText: String? = null,
    val hint: String,
    val isError: Boolean = false
)