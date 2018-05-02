package com.sum.rvadapter

import android.content.Intent
import com.sum.library.app.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun initParams() {

        btn_1.setOnClickListener {
            startActivity(Intent(this@MainActivity,SimpleActivity::class.java))
        }

        btn_2.setOnClickListener {
            startActivity(Intent(this@MainActivity,MulitActivity::class.java))
        }

    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
