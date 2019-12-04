package cz.kopemar.listdetail

import android.app.Application
import cz.kopemar.listdetail.di.applicationModule
import cz.kopemar.listdetail.di.githubModule
import cz.kopemar.listdetail.di.networkModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule, networkModule, githubModule))
    }

}