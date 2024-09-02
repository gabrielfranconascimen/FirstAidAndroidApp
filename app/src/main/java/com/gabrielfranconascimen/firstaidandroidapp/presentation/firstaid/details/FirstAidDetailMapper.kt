package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail

class FirstAidDetailMapper {

    fun mapInitialState(title: String): FirstAidDetailViewState {
        return FirstAidDetailViewState(
            loading = true,
            error = false,
            data = FirstAidDetailScreenEntity(
                title = title,
                steps = listOf()
            )
        )
    }

    fun mapSteps(firstAidDetail: FirstAidDetail?): FirstAidDetailScreenEntity? {
        return firstAidDetail?.let {
            FirstAidDetailScreenEntity(
                it.identifier,
                it.steps.mapIndexed { index, step ->
                    FirstAidDetailStepScreenEntity(
                        step = "${index + 1}",
                        label = step
                    )
                }
            )
        }
    }
}