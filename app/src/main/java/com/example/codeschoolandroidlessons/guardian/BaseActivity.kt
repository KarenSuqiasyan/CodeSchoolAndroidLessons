package com.example.codeschoolandroidlessons.guardian

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.codeschoolandroidlessons.guardian.util.NetworkLiveData

open class BaseActivity : AppCompatActivity() {

    private lateinit var networkLiveData: NetworkLiveData

    fun replaceFragment(fragment: Fragment, resId: Int) {
        supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
    }

    fun checkNetworkConnection(textView: TextView) {
        networkLiveData = NetworkLiveData(application)

        networkLiveData.observe(this) { isConnected ->
            if (isConnected) {
                textView.visibility = View.GONE
            } else {
                textView.visibility = View.VISIBLE
            }
        }
    }
}