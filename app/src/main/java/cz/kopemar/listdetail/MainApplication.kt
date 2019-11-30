package cz.kopemar.listdetail

import android.app.Application
import cz.kopemar.listdetail.application.applicationModule
import cz.kopemar.listdetail.viewmodel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.*


class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }

}