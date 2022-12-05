package com.common

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.common.utils.NetworkLiveData

abstract class BaseCommonActivity : AppCompatActivity() {

    abstract fun noInternetView(): View

    private lateinit var networkLiveData: NetworkLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkLiveData = NetworkLiveData(application)

        networkLiveData.observe(this) { isConnected ->
            if (isConnected) {
                noInternetView().visibility = View.GONE
            } else {
                noInternetView().visibility = View.VISIBLE
            }
        }
    }

//    @Deprecated("Use Navigation Graph instead")
//    fun replaceFragment(fragment: Fragment, resId: Int) {
//        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
//    }
//
//    fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
//    }
}