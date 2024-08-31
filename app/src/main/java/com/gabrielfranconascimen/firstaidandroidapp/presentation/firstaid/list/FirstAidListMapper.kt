package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid

class FirstAidListMapper {
    fun map(items: List<FirstAid>): List<FirstAidListScreenEntity> {
        return items.map {
            FirstAidListScreenEntity(
                title = it.title,
                description = it.description,
                detailId = it.detailId
            )
        }
    }
}