package com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielfranconascimen.designsystem.components.buttons.FAButtonState
import com.gabrielfranconascimen.firstaidandroidapp.common.network.withApiErrorHandling
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.EmailValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.GetUser
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.LogOutUser
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.PasswordValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.SignInUser
import com.gabrielfranconascimen.firstaidandroidapp.presentation.FAViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val mapper: SignInMapper,
    private val passwordValidator: PasswordValidator,
    private val emailValidator: EmailValidator,
    private val signInUser: SignInUser,
    private val logOutUser: LogOutUser,
    private val getUser: GetUser
) : ViewModel(), SignInScreenActions {

    private val _viewState = MutableStateFlow(SignInViewState())
    val viewState: StateFlow<SignInViewState> = _viewState

    private var _email = ""
    private var _password = ""

    init {
        _viewState.value = mapper.initialState(isLogged = getUser.isLogged())
    }

    fun closeDialogError() {
        _viewState.update {
            it.copy(error = false)
        }
    }

    override fun onEmailChanged(email: String) {
        _email = email
        val isValid = emailValidator.execute(_email)
        _viewState.update {
            it.copy(
                data = it.data?.copy(
                    buttonState = buttonEnabled(),
                    emailFieldEntity = mapper.mapEmailTextField(
                        value = _email,
                        isError = !isValid
                    )
                )
            )
        }
    }

    override fun onPasswordChanged(password: String) {
        _password = password
        val isValid = passwordValidator.execute(_password)
        _viewState.update {
            it.copy(
                data = it.data?.copy(
                    buttonState = buttonEnabled(),
                    passwordFieldEntity = mapper.mapPasswordTextField(
                        value = _password,
                        isError = !isValid
                    )
                )
            )
        }
    }

    override fun onEnterClicked() {
        _viewState.update {
            it.copy(data = it.data?.copy(buttonState = FAButtonState.Loading))
        }
        viewModelScope.launch { delay(2000)
            val user = signInUser.execute(_email, _password)
            if (user != null) {
                _viewState.update {
                    it.copy(data = it.data?.copy(buttonState = buttonEnabled(), isLogged = getUser.isLogged()))
                }
            } else {
                updateViewStateError()
            }
        }
    }

    private fun updateViewStateError() {
        _viewState.update { it.copy(error = true, data = it.data?.copy(buttonState = buttonEnabled())) }
    }

    override fun onLogoutClicked() {
        viewModelScope.launch {
            withApiErrorHandling(runBlock = {
                logOutUser.execute()
                _viewState.update {
                    it.copy(data = it.data?.copy(isLogged = getUser.isLogged()))
                }
            })
        }
    }

    private fun buttonEnabled(): FAButtonState {
        val isEnabled = emailValidator.execute(_email) && passwordValidator.execute(_password)
        return if (isEnabled) FAButtonState.Idle else FAButtonState.Disable
    }
}

data class SignInViewState(
    override var loading: Boolean = false,
    override var data: SignInScreenEntity? = null,
    override var error: Boolean = false
) : FAViewState<SignInScreenEntity>