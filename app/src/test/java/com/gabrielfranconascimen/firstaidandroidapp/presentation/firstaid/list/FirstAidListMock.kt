package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid

class FirstAidListMock {
    companion object {
        fun mockRepositorySuccess(): List<FirstAid> {
            return listOf(
                FirstAid(
                    title = "Title 1",
                    description = "Description 1",
                    detailId = "test_id_1"
                ),
                FirstAid(
                    title = "Title 2",
                    description = "Test 2",
                    detailId = "id_2"
                ),
                FirstAid(
                    title = "Title 3",
                    description = "Description 3",
                    detailId = "id_3"
                )
            )
        }

        fun mockMapperSuccess(): List<FirstAidListScreenEntity> {
            return listOf(
                FirstAidListScreenEntity(
                    title = "Test title 1",
                    description = "Test description 1",
                    detailId = "test_id_1"
                ),
                FirstAidListScreenEntity(
                    title = "Test title 2",
                    description = "Test description 2",
                    detailId = "test_id_2"
                ),
                FirstAidListScreenEntity(
                    title = "Test title 3",
                    description = "Test description 3",
                    detailId = "test_id_3"
                )
            )
        }
    }
}