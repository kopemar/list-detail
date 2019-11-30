package cz.kopemar.listdetail

import android.app.Application
import cz.kopemar.listdetail.application.applicationModule
import org.koin.android.ext.android.startKoin


class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }

}