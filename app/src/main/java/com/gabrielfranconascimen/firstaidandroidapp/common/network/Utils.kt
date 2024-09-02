package com.gabrielfranconascimen.firstaidandroidapp.common.network

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FAError
import kotlinx.coroutines.CancellationException

inline fun withApiErrorHandling(
    noinline onError: ((FAError) -> Unit)? = null,
    runBlock: () -> Unit
) {
    try {
        runBlock()
    } catch (exception: Exception) {
        if (exception !is CancellationException) {
            onError?.invoke(FAError(exception.message ?: "Tivemos um problema para obter os dados"))
        }
    }
}


