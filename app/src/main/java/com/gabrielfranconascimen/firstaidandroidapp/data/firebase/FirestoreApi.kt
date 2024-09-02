package com.gabrielfranconascimen.firstaidandroidapp.data.firebase

import com.gabrielfranconascimen.firstaidandroidapp.common.network.Endpoints
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidDetailResponse
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine

class FirestoreApi {
    private val dbFirestore = Firebase.firestore

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getFirstAidList(): List<FirstAidResponse?>? {
        return suspendCancellableCoroutine { continution ->
            dbFirestore
                .collection(Endpoints.FirstAidFirestore.list)
                .get()
                .addOnSuccessListener { document ->
                    val items = document.documents.map { it.toObject<FirstAidResponse>() }
                    continution.resume(items, null)
                }
                .addOnFailureListener {
                    continution.resume(null, null)
                }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getFirstAidDetailWithId(id: String): FirstAidDetailResponse? {
        return suspendCancellableCoroutine { continuation ->
            dbFirestore
                .collection(Endpoints.FirstAidFirestore.details)
                .document(id)
                .get()
                .addOnSuccessListener { result ->
                    val data = result.toObject<FirstAidDetailResponse>()
                    continuation.resume(data, null)
                }
                .addOnFailureListener {
                    continuation.resume(null, null)
                }
        }
    }
}