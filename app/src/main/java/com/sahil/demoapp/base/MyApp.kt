package com.sahil.demoapp.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //before live comment this line
        plant(DebugTree())
    }
}