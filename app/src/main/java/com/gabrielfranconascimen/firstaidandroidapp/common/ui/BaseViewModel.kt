package com.gabrielfranconascimen.firstaidandroidapp.common.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<VS: FAViewState, A: FAAction>: ViewModel() {

    protected val _viewState = MutableStateFlow<FAViewState>(DefaultState)
    val viewState: StateFlow<FAViewState> = _viewState

    protected val _action = MutableLiveData<FAEvent<A>>()
    val action: LiveData<FAEvent<A>> = _action
}

interface FAAction
interface FAViewState

data object DefaultState: FAViewState