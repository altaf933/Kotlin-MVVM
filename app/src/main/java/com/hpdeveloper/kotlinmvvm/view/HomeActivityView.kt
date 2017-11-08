package com.hpdeveloper.kotlinmvvm.view

import com.hpdeveloper.rxkotlinmvvm.model.AndroidOS

/**
 * Created by hirenpatel on 07/11/17.
 */
interface HomeActivityView : IView {

    fun OnDataLoad(item: String)
    fun onAndroidOSLoad(androidOSs: List<AndroidOS>)


}