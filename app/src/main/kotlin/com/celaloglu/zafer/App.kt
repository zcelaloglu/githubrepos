package com.celaloglu.zafer

import android.app.Application
import com.celaloglu.zafer.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                databaseModule,
                dataSourceModule,
                repositoriesModule,
                useCasesModule,
                viewModelsModule
            )
        }
    }
}