package com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin

import com.gabrielfranconascimen.designsystem.components.texts.models.FATextFieldEntity

class SignInMapper {

    fun initialState(
        isLogged: Boolean,
    ): SignInViewState {
        return SignInViewState(
            loading = false,
            error = false,
            data = SignInScreenEntity(
                name = "",
                isLogged = isLogged,
                emailFieldEntity = mapEmailTextField(value = "", isError = false),
                passwordFieldEntity = mapPasswordTextField(value = "", isError = false)
            )
        )
    }

    fun mapEmailTextField(
        value: String,
        isError: Boolean
    ) = FATextFieldEntity(
        value = value,
        isError = isError,
        hint = "E-mail",
        supportingText = if (isError) "E-mail inválido" else null
    )

    fun mapPasswordTextField(
        value: String,
        isError: Boolean
    ) = FATextFieldEntity(
            value = value,
            isError = isError,
            hint = "password",
            supportingText = when {
                value.isEmpty() -> "A senha deve contar ao menos 8 caracteres, sendo uma letra minuscula, maiscula, numero e caracter especial"
                isError -> "Senha não atende a um dos requisitos, um caracter especial, uma letra maiúscula, minúscula, número."
                else -> null
            }
        )
}