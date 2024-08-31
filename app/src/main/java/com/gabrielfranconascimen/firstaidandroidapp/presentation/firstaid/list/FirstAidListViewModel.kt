package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import androidx.lifecycle.viewModelScope
import com.gabrielfranconascimen.firstaidandroidapp.common.ui.BaseViewModel
import com.gabrielfranconascimen.firstaidandroidapp.common.ui.FAAction
import com.gabrielfranconascimen.firstaidandroidapp.common.ui.FAViewState
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FirstAidListViewModel(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val mapper: FirstAidListMapper
): BaseViewModel<FirstAidViewState, FAAction>() {

    init {
        _viewState.value = FirstAidViewState.Loading
        loadData()
    }

    fun tryAgain() {
        _viewState.update {
            FirstAidViewState.Loading
        }
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val list = getFirstAidRepository.getFirstAidList()
            _viewState.update {
                FirstAidViewState.Success(mapper.map(list))
            }
        }
    }
}

sealed interface FirstAidViewState: FAViewState {
    data object Loading: FirstAidViewState
    data class Error(val error: String): FirstAidViewState
    data class Success(val data: List<FirstAidListScreenEntity>): FirstAidViewState
}
