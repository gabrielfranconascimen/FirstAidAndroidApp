package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail

class FirstAidDetailMapper {

    fun mapInitialState(title: String): FirstAidDetailViewState {
        return FirstAidDetailViewState(
            loading = true,
            error = false,
            data = NewFirstAidDetailScreenEntity(
                title = title,
                steps = listOf()
            )
        )
    }

    fun mapSteps(firstAidDetail: FirstAidDetail): List<FirstAidDetailScreenEntity> {
        return firstAidDetail.steps.mapIndexed { index, step ->
            FirstAidDetailScreenEntity(
                step = "${index+1}",
                label = step
            )
        }
    }
}