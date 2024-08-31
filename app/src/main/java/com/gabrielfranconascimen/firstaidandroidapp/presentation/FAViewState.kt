package com.gabrielfranconascimen.firstaidandroidapp.presentation

interface FAViewState<T> {
    var loading: Boolean
    var data: T?
    var error: Boolean
}
