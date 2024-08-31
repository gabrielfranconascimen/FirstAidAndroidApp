package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail

class FirstAidDetailMapper {
    fun map(firstAidDetail: FirstAidDetail): List<FirstAidDetailScreenEntity> {
        return firstAidDetail.steps.mapIndexed { index, step ->
            FirstAidDetailScreenEntity(
                step = "${index+1}",
                label = step
            )
        }
    }
}