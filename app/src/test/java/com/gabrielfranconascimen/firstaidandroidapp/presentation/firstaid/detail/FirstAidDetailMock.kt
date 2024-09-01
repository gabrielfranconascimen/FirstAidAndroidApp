package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.detail

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailScreenEntity
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailStepScreenEntity

class FirstAidDetailMock {
    companion object {
        fun mockRepository(): FirstAidDetail {
            return FirstAidDetail(
                identifier = "Procedimentos",
                steps = listOf(
                    "Procedimento 0",
                    "Procedimento 1",
                    "Procedimento 2"
                )
            )
        }

        fun mapSteps(): FirstAidDetailScreenEntity {
            return FirstAidDetailScreenEntity(
                "Procedimentos",
                listOf(
                    FirstAidDetailStepScreenEntity(
                        step = "1",
                        label = "Procedimento 0"
                    ),
                    FirstAidDetailStepScreenEntity(
                        step = "2",
                        label = "Procedimento 1"
                    ),
                    FirstAidDetailStepScreenEntity(
                        step = "3",
                        label = "Procedimento 2"
                    )
                )
            )
        }
    }
}