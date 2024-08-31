package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _viewState = MutableStateFlow(FirstAidDetailViewState(loading = true))
    val viewState: StateFlow<FirstAidDetailViewState> = _viewState

    private var _title: String = ""
    private var _detailId: String = ""

    fun start(title: String, detailId: String) {
        _viewState.update {
            it.copy(
                loading = true,
                error = false,
                data = NewFirstAidDetailScreenEntity(
                    title = title,
                    steps = listOf()
                )
            )
        }
        _title = title
        _detailId = detailId
        viewModelScope.launch {
            val firstAidDetail = getFirsAidDetail.execute(detailId)
            _viewState.update {
                it.copy(
                    loading = false,
                    data = NewFirstAidDetailScreenEntity(
                        title = title,
                        steps = mapper.map(firstAidDetail)
                    )
                )
            }
        }
    }

    fun tryAgain() {
        start(_title, _detailId)
    }

}

data class FirstAidDetailViewState(
    override var loading: Boolean = false,
    override var data: NewFirstAidDetailScreenEntity? = null,
    override var error: Boolean = false
) : FAViewState<NewFirstAidDetailScreenEntity>