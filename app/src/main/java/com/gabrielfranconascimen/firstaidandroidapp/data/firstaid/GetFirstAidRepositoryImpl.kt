package com.gabrielfranconascimen.firstaidandroidapp.data.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid

class GetFirstAidRepositoryImpl: GetFirstAidRepository {

    override suspend fun getFirstAidList(): List<FirstAid> {
        return localReturn()
    }

    override suspend fun getFirstAidDetailWithId(id: String): String {
        return ""
    }
}

private fun GetFirstAidRepositoryImpl.localReturn(): List<FirstAid> {
    return listOf(
        FirstAid(
            title = "Test 1",
            description = "Test descripton 1",
            detailId = "id1"
        ),
        FirstAid(
            title = "Test 2",
            description = "Test description 2",
            detailId = "id2"
        ),
        FirstAid(
            title = "Test 3",
            description = "Test description 3",
            detailId = "id3"
        )
    )
}