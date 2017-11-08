package com.hpdeveloper.kotlinmvvm.activities

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import com.hpdeveloper.kotlinmvvm.viewmodel.BaseViewModel

abstract class BaseActivity<B : ViewDataBinding, T : BaseViewModel<*>> : AppCompatActivity() {

    protected lateinit var dataBinding: B
    protected var baseViewModel: T? = null

    protected fun bindView(layoutId: Int) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onDestroy() {
        baseViewModel!!.detachView()
        super.onDestroy()
    }
}