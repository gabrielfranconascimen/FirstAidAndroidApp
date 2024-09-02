package com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid
import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import kotlinx.coroutines.withContext

interface GetFirstAidList {
    suspend fun execute(): List<FirstAid>?
}

class GetFirstAidListImpl(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val dispatcher: FADispatcher,
    private val mapper: GetFirstAidMapper
): GetFirstAidList {

    override suspend fun execute(): List<FirstAid>? = withContext(dispatcher.io) {
        val firstAidListRawFiltered = getFirstAidRepository.getFirstAidList()?.filterNotNull()
        firstAidListRawFiltered?.map { mapper.mapFirstAidResponseToFirstAid(it) }
    }

}