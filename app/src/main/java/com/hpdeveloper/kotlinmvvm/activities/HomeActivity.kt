package com.hpdeveloper.kotlinmvvm.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import com.hpdeveloper.kotlinmvvm.R
import com.hpdeveloper.kotlinmvvm.databinding.ActivityHomeBinding
import com.hpdeveloper.kotlinmvvm.view.HomeActivityView
import com.hpdeveloper.kotlinmvvm.viewmodel.HomeActivityViewModel

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeActivityViewModel>(), HomeActivityView, View.OnClickListener {

    val TAG : String = "HomeActivity"

    override fun onClick(v: View?) {
        baseViewModel!!.loadNextData()
    }

    override fun OnDataLoad(item: String) {
        Log.e(TAG, item)
    }

    override fun OnError(throwable: Throwable) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindView(R.layout.activity_home)

        baseViewModel = HomeActivityViewModel()
        baseViewModel!!.attachView(this)

        dataBinding.btnPerformOperation.setOnClickListener(this)
    }


}
