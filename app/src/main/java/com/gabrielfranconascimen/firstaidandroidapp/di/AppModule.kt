package com.gabrielfranconascimen.firstaidandroidapp.di

import com.gabrielfranconascimen.firstaidandroidapp.presentation.di.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(
        presentationModule
    )
}