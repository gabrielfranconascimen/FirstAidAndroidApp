package com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielfranconascimen.firstaidandroidapp.common.network.withApiErrorHandling
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.EmailValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.LogOutUser
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.PasswordValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.SignInUser
import com.gabrielfranconascimen.firstaidandroidapp.presentation.FAViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val mapper: SignInMapper,
    private val passwordValidator: PasswordValidator,
    private val emailValidator: EmailValidator,
    private val signInUser: SignInUser,
    private val logOutUser: LogOutUser
) : ViewModel(), SignInScreenActions {

    private val _viewState = MutableStateFlow(SignInViewState())
    val viewState: StateFlow<SignInViewState> = _viewState

    private var _email = ""
    private var _password = ""

    init {
        _viewState.value = mapper.initialState(false)
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
                    passwordFieldEntity = mapper.mapPasswordTextField(
                        value = _password,
                        isError = !isValid
                    )
                )
            )
        }
    }

    override fun onEnterClicked() {
        viewModelScope.launch {
            withApiErrorHandling(
                runBlock = {
                    signInUser.execute(_email, _password)
                    _viewState.update {
                        it.copy(data = it.data?.copy(isLogged = true))
                    }
                },
                onError = {
                    _viewState.update {
                        it.copy(error = true)
                    }
                }
            )
        }
    }

    override fun onLogoutClicked() {
        viewModelScope.launch {
            withApiErrorHandling(runBlock = {
                logOutUser.execute()
                _viewState.update {
                    it.copy(data = it.data?.copy(isLogged = false))
                }
            })
        }
    }
}

data class SignInViewState(
    override var loading: Boolean = false,
    override var data: SignInScreenEntity? = null,
    override var error: Boolean = false
) : FAViewState<SignInScreenEntity>