package com.gabrielfranconascimen.firstaidandroidapp.data.models

import androidx.annotation.Keep
import com.google.firebase.firestore.DocumentReference

@Keep
data class FirstAidResponse(
    val title: String = "",
    val description: String = "",
    val detailsId: DocumentReference? = null
)