package com.gabrielfranconascimen.firstaidandroidapp.common.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class FAEvent<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

fun interface EventObserver<T>: Observer<FAEvent<T>?> {
    fun onValueChanged(value: T)

    override fun onChanged(value: FAEvent<T>?) {
        value?.getContentIfNotHandled()?.let { onValueChanged(it) }
    }
}

fun <T> LiveData<FAEvent<T>>.observeEvent(owner: LifecycleOwner, observer: EventObserver<T>) {
    this.observe(owner, observer)
}

fun <T> MutableLiveData<FAEvent<T>>.postEvent(event: T) = this.postValue(FAEvent(event))