package com.lordmegamax.omdbandroidclient

import android.app.Application
import com.lordmegamax.omdbandroidclient.di.appModule
import com.lordmegamax.omdbandroidclient.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OmdbClientApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@OmdbClientApp)
            modules(appModule, networkModule)
        }
    }
}