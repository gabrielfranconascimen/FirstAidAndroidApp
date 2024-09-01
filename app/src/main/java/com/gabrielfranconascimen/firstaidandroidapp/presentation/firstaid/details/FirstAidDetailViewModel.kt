package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabrielfranconascimen.firstaidandroidapp.common.network.withApiErrorHandling
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.presentation.FAViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FirstAidDetailViewModel(
    private val getFirsAidDetail: GetFirstAidDetail,
    private val mapper: FirstAidDetailMapper
): ViewModel() {

    private val _viewState = MutableStateFlow(FirstAidDetailViewState())
    val viewState: StateFlow<FirstAidDetailViewState> = _viewState

    private var _title: String = ""
    private var _detailId: String = ""

    fun start(title: String, detailId: String) {
        _viewState.update { mapper.mapInitialState(title) }
        _title = title
        _detailId = detailId
        loadData()
    }

    fun tryAgain() {
        _viewState.update { it.copy(loading = true, error = false) }
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withApiErrorHandling(
                onError = {
                    _viewState.update {
                        it.copy(loading = false, error = true)
                    }
                },
                runBlock = {
                    val firstAidDetail = getFirsAidDetail.execute(_detailId)
                    _viewState.update {
                        it.copy(
                            loading = false,
                            data = it.data?.copy(steps = mapper.mapSteps(firstAidDetail))
                        )
                    }
                }
            )
        }
    }
}

data class FirstAidDetailViewState(
    override var loading: Boolean = false,
    override var data: NewFirstAidDetailScreenEntity? = null,
    override var error: Boolean = false
) : FAViewState<NewFirstAidDetailScreenEntity>