package com.gabrielfranconascimen.firstaidandroidapp.presentation.di

import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailViewModel
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list.FirstAidListMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list.FirstAidListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single { FirstAidListMapper() }
    single { FirstAidDetailMapper() }
    viewModel { FirstAidListViewModel(getList = get(), mapper = get()) }
    viewModel { FirstAidDetailViewModel(getFirsAidDetail = get(), mapper = get()) }
}