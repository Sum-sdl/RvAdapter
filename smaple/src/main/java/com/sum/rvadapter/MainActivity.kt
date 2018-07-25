package com.sum.rvadapter

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initParams()
    }

    fun initParams() {

        btn_1.setOnClickListener {
            startActivity(Intent(this@MainActivity, SimpleActivity::class.java))
        }

        btn_2.setOnClickListener {
            startActivity(Intent(this@MainActivity, MulitActivity::class.java))
        }

        btn_3.setOnClickListener {
            startActivity(Intent(this@MainActivity, StickActivity::class.java))
        }

    }

    fun getLayoutId(): Int = R.layout.activity_main

}
