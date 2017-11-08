package com.hpdeveloper.kotlinmvvm.viewmodel

import com.hpdeveloper.kotlinmvvm.view.IView

/**
 * Created by hirenpatel on 07/11/17.
 */
open class BaseViewModel<T : IView> {

    var view: T? = null

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}