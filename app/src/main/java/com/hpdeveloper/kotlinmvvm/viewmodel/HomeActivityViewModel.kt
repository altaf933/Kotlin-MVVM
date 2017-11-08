package com.hpdeveloper.kotlinmvvm.viewmodel

import com.hpdeveloper.kotlinmvvm.view.HomeActivityView

/**
 * Created by hirenpatel on 07/11/17.
 */
class HomeActivityViewModel : BaseViewModel<HomeActivityView>() {

    fun loadNextData() {
        view!!.OnDataLoad("Test")
    }

}