package com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import kotlinx.coroutines.withContext

interface GetFirstAidDetail {
    suspend fun execute(detailId: String): FirstAidDetail
}

class GetFirstAidDetailImpl(
    private val getFirstAidRepository: GetFirstAidRepository,
    private val dispatcher: FADispatcher,
    private val mapper: GetFirstAidMapper
): GetFirstAidDetail {

    override suspend fun execute(detailId: String): FirstAidDetail = withContext(dispatcher.io){
        val response = getFirstAidRepository.getFirstAidDetailWithId(detailId)
        response?.let {
            return@withContext mapper.mapDetailResponseToDetail(it)
        } ?: throw ObjectInvalidException()
    }
}

class ObjectInvalidException: Exception("Problema when receive detail when identifier item")


