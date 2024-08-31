package com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository

interface GetFirstAidDetail {
    suspend fun execute(detailId: String): FirstAidDetail
}

class GetFirstAidDetailImpl(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val mapper: GetFirstAidMapper
): GetFirstAidDetail {

    override suspend fun execute(detailId: String): FirstAidDetail {
        getFirstAidRepository.getFirstAidDetailWithId(detailId)
        return FirstAidDetail(
            identifier = "Test",
            steps = listOf(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum ha",
                "urvived not only five centuries",
                "typesetting, remaining essentially unchanged. It was popularised in "
            )
        )
    }

}


