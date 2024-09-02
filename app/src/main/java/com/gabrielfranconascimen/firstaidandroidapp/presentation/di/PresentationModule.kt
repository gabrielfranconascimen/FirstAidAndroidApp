package com.gabrielfranconascimen.firstaidandroidapp.presentation.di

import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailViewModel
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list.FirstAidListMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list.FirstAidListViewModel
import com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin.SignInMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single { FirstAidListMapper() }
    single { FirstAidDetailMapper() }
    single { SignInMapper() }
    viewModel { FirstAidListViewModel(getList = get(), mapper = get()) }
    viewModel { FirstAidDetailViewModel(getFirsAidDetail = get(), mapper = get()) }
    viewModel { SignInViewModel(
        mapper = get(),
        emailValidator = get(),
        passwordValidator = get(),
        signInUser = get(),
        logOutUser = get()
        )
    }
}