package com.gabrielfranconascimen.firstaidandroidapp.data.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidDetailResponse
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidResponse

interface GetFirstAidRepository {
    suspend fun getFirstAidList(): List<FirstAidResponse?>?
    suspend fun getFirstAidDetailWithId(id: String): FirstAidDetailResponse?
}