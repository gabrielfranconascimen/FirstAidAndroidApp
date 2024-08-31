package com.gabrielfranconascimen.firstaidandroidapp.data.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid

interface GetFirstAidRepository {
    suspend fun getFirstAidList(): List<FirstAid>
    suspend fun getFirstAidDetailWithId(id: String): String
}