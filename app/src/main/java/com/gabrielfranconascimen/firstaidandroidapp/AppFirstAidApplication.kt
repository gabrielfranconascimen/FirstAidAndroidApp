package com.gabrielfranconascimen.firstaidandroidapp

import android.app.Application
import com.gabrielfranconascimen.firstaidandroidapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppFirstAidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppFirstAidApplication)
            modules(appModule)
        }
    }
}