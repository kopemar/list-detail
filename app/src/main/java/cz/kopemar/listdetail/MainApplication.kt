package cz.kopemar.listdetail

import android.app.Application
import cz.kopemar.listdetail.di.applicationModule
import cz.kopemar.listdetail.di.githubModule
import cz.kopemar.listdetail.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(applicationModule, networkModule, githubModule))
        }
    }

}