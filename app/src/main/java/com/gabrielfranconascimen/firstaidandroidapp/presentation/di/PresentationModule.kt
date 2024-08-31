package com.gabrielfranconascimen.firstaidandroidapp.presentation.di

import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list.FirstAidListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FirstAidListViewModel() }
    factory { Dispatchers.IO }
}