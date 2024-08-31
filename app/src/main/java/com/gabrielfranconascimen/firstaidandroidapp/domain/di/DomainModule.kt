package com.gabrielfranconascimen.firstaidandroidapp.domain.di

import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidMapper
import org.koin.dsl.module

val domainModule = module {
    single { GetFirstAidMapper() }
}