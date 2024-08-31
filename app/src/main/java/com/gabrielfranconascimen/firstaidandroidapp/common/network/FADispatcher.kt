package com.gabrielfranconascimen.firstaidandroidapp.common.network

import kotlinx.coroutines.CoroutineDispatcher

interface FADispatcher {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}