package com.gabrielfranconascimen.firstaidandroidapp.data.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.data.firebase.FirestoreApi
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidDetailResponse
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidResponse

class GetFirstAidRepositoryImpl(
    private val firestoreApi: FirestoreApi
): GetFirstAidRepository {

    override suspend fun getFirstAidList(): List<FirstAidResponse?>? {
        return firestoreApi.getFirstAidList()
    }

    override suspend fun getFirstAidDetailWithId(id: String): FirstAidDetailResponse? {
        return firestoreApi.getFirstAidDetailWithId(id)
    }
}