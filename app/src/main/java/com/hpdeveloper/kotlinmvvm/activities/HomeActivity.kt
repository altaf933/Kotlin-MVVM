package com.hpdeveloper.kotlinmvvm.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import com.hpdeveloper.kotlinmvvm.MyApplication
import com.hpdeveloper.kotlinmvvm.R
import com.hpdeveloper.kotlinmvvm.databinding.ActivityHomeBinding
import com.hpdeveloper.kotlinmvvm.view.HomeActivityView
import com.hpdeveloper.kotlinmvvm.viewmodel.HomeActivityViewModel
import com.hpdeveloper.rxkotlinmvvm.api.GetAndroidOS
import com.hpdeveloper.rxkotlinmvvm.model.AndroidOS
import javax.inject.Inject
import com.hpdeveloper.kotlinmvvm.adapters.AndroidOSAdapter
import com.hpdeveloper.kotlinmvvm.R.id.recyclerView
import android.support.v7.widget.LinearLayoutManager





class HomeActivity : BaseActivity<ActivityHomeBinding, HomeActivityViewModel>(), HomeActivityView, View.OnClickListener {

    @Inject lateinit var getAndroidOSModule: GetAndroidOS
    var androidOSAdapter: AndroidOSAdapter? = null


    override fun onAndroidOSLoad(androidOSs: List<AndroidOS>) {
        for (androidOS in androidOSs) {
            Log.e("OS Name", androidOS.name)
        }

        dataBinding.setIsLoading(false);
        androidOSAdapter!!.updateData(androidOSs);
    }

    val TAG : String = "HomeActivity"

    override fun onClick(v: View?) {
        baseViewModel!!.getAndroidOS(getAndroidOSModule)
    }

    override fun OnDataLoad(item: String) {
        Log.e(TAG, item)
    }

    override fun OnError(throwable: Throwable) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApplication.appComponent.inject(this)
        bindView(R.layout.activity_home)

        baseViewModel = HomeActivityViewModel()
        baseViewModel!!.attachView(this)

        dataBinding.setIsLoading(true)
        baseViewModel!!.getAndroidOS(getAndroidOSModule)
        dataBinding.recyclerView.setLayoutManager(LinearLayoutManager(this))
        androidOSAdapter = AndroidOSAdapter()
        dataBinding.recyclerView.setAdapter(androidOSAdapter)

//        dataBinding.btnPerformOperation.setOnClickListener(this)
    }


}
