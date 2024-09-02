package com.gabrielfranconascimen.firstaidandroidapp.data.di

import com.gabrielfranconascimen.firstaidandroidapp.common.network.FADispatcher
import com.gabrielfranconascimen.firstaidandroidapp.data.firebase.AuthApi
import com.gabrielfranconascimen.firstaidandroidapp.data.firebase.FirestoreApi
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepository
import com.gabrielfranconascimen.firstaidandroidapp.data.firstaid.GetFirstAidRepositoryImpl
import com.gabrielfranconascimen.firstaidandroidapp.data.signin.SignInRepository
import com.gabrielfranconascimen.firstaidandroidapp.data.signin.SignInRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single { AuthApi() }
    single { FirestoreApi() }
    single { provideFADispatcher() }
    single<GetFirstAidRepository> { GetFirstAidRepositoryImpl(get()) }
    single<SignInRepository> { SignInRepositoryImpl(get()) }
}

private fun provideFADispatcher(): FADispatcher {
    return object : FADispatcher {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
    }
}