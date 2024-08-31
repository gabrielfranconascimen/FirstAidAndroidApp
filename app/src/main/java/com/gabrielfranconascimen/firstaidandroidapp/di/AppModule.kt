package com.gabrielfranconascimen.firstaidandroidapp.di

import com.gabrielfranconascimen.firstaidandroidapp.data.di.dataModule
import com.gabrielfranconascimen.firstaidandroidapp.domain.di.domainModule
import com.gabrielfranconascimen.firstaidandroidapp.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(
        presentationModule,
        domainModule,
        dataModule
    )
}