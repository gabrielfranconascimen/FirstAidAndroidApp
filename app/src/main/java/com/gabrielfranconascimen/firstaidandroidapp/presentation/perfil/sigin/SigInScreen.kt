package com.gabrielfranconascimen.firstaidandroidapp.presentation.perfil.sigin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.buttons.FAButton
import com.gabrielfranconascimen.designsystem.components.texts.FAText
import com.gabrielfranconascimen.designsystem.components.texts.FATextField
import com.gabrielfranconascimen.firstaidandroidapp.R

@Composable
fun SigInScreen(
    content: SigInScreenEntity,
    screenActions: SigInScreenActions
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(Dimens.avatarIconSize),
            painter = painterResource(id = R.drawable.ic_account_circle_24),
            contentDescription = ""
        )
        if (content.isLogged) {
            LoggedContent(content.name, screenActions)
        } else {
            SigInContent(content.email, content.password, screenActions)
        }
    }
}

@Composable
private fun SigInContent(
    email: String,
    password: String,
    screenActions: SigInScreenActions
) {
    val focusManager = LocalFocusManager.current
    FATextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.mediumPadding),
        value = email,
        onValueChange = { screenActions.onEmailChanged(it) }
    )
    Spacer(modifier = Modifier.height(Dimens.smallPadding))
    FATextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.mediumPadding),
        value = password,
        onValueChange = { screenActions.onPasswordChanged(it) }
    )
    Spacer(modifier = Modifier.height(Dimens.mediumPadding))
    FAButton(
        onClick = {
            focusManager.clearFocus()
            screenActions.onEnterClicked()
        }
    ) {
        FAText(text = stringResource(id = R.string.sig_in_button))
    }
}

@Composable
private fun LoggedContent(
    name: String,
    screenActions: SigInScreenActions
) {
    FAText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.mediumPadding),
        text = "Olá $name",
        align = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge
    )

    FAButton(onClick = { screenActions.onLogoutClicked() }) {
        FAText(text = stringResource(id = R.string.log_out_button))
    }
}

data class SigInScreenEntity(
    val name: String,
    val isLogged: Boolean,
    val email: String,
    val password: String
)

interface SigInScreenActions {
    fun onEmailChanged(email: String)
    fun onPasswordChanged(password: String)
    fun onEnterClicked()
    fun onLogoutClicked()
}

@Composable
@Preview
private fun SigInScreenPreview() {
    FATheme {
        SigInScreen(
            content = SigInScreenEntity(
                name = "Gabriel ",
                isLogged = true,
                email = "",
                password = ""
            ),
            screenActions = object : SigInScreenActions{
                override fun onEmailChanged(email: String) { }
                override fun onPasswordChanged(password: String) { }
                override fun onEnterClicked() { }
                override fun onLogoutClicked() { }
            }
        )
    }
}