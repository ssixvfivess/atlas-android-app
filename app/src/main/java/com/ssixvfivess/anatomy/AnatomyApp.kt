package com.ssixvfivess.anatomy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import firebase.com.protolitewrapper.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class AnatomyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}