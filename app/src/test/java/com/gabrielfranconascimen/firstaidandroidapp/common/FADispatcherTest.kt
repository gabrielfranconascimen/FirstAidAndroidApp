package com.gabrielfranconascimen.firstaidandroidapp.common

import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class FADispatcherTest: FADispatcher {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val io: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val default: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}