package com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import kotlinx.coroutines.withContext

interface GetFirstAidDetail {
    suspend fun execute(detailId: String): FirstAidDetail?
}

class GetFirstAidDetailImpl(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val dispatcher: FADispatcher,
    private val mapper: GetFirstAidMapper
): GetFirstAidDetail {

    override suspend fun execute(detailId: String): FirstAidDetail? = withContext(dispatcher.io){
        getFirstAidRepository.getFirstAidDetailWithId(detailId)?.let {
            mapper.mapDetailResponseToDetail(it)
        }
    }
}



