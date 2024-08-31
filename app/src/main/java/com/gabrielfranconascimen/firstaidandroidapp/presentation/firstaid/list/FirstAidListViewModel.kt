package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import com.gabrielfranconascimen.firstaidandroidapp.presentation.FAViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FirstAidListViewModel(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val mapper: FirstAidListMapper
): ViewModel() {

    private val _viewState = MutableStateFlow(FirstAidViewState())
    val viewState: StateFlow<FirstAidViewState> = _viewState

    init {
        loadData()
    }

    fun tryAgain() {
        loadData()
    }

    private fun loadData() {
        _viewState.update { it.copy(loading = true, error = false) }
        viewModelScope.launch {
            val list = getFirstAidRepository.getFirstAidList()
            _viewState.update {
                it.copy(
                    loading = false,
                    data = mapper.map(list)
                )
            }
        }
    }
}

data class FirstAidViewState(
    override var loading: Boolean = false,
    override var data: List<FirstAidListScreenEntity>? = listOf(),
    override var error: Boolean = false
) : FAViewState<List<FirstAidListScreenEntity>?>
