package com.hpdeveloper.kotlinmvvm

import android.app.Application
import com.hpdeveloper.rxkotlinmvvm.di.component.AppComponent
import com.hpdeveloper.rxkotlinmvvm.di.component.DaggerAppComponent

/**
 * Created by hirenpatel on 08/11/17.
 */
class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .build()

    }
}