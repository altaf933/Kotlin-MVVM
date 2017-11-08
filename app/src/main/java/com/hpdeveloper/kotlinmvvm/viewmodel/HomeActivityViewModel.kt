package com.hpdeveloper.kotlinmvvm.viewmodel

import android.widget.Toast
import com.hpdeveloper.kotlinmvvm.view.HomeActivityView
import com.hpdeveloper.rxkotlinmvvm.api.GetAndroidOS
import dagger.Component
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by hirenpatel on 07/11/17.
 */
class HomeActivityViewModel : BaseViewModel<HomeActivityView>() {


    fun loadNextData() {
        view!!.OnDataLoad("Test")
    }

    fun getAndroidOS(androidOSModule: GetAndroidOS){
        val subscriptions = CompositeDisposable()
        subscriptions.add(androidOSModule.getAndroidOS().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
            view!!.onAndroidOSLoad(it)
        }, {
           view!!.OnError(it)
        }))
    }

}