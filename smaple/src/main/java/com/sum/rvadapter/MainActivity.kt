package com.sum.rvadapter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
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

        btn_4.setOnClickListener {
            startActivity(Intent(this@MainActivity, SpaceActivity::class.java))
        }

        //锁屏消息界面
//        btn_3.postDelayed(({ send("新消息1") }), 5000)
//        btn_3.postDelayed(({ send("新消息2") }), 12000)
//        btn_3.postDelayed(({ send("新消息3") }), 22000)
//        btn_3.postDelayed(({ send("新消息4") }), 30000)

    }

    var index = 1
    private fun send(msg: String) {
        val intent = Intent()
        intent.action = "com.fu"
        intent.putExtra("msg", msg)
        sendBroadcast(intent);
        Log.e("phone", "第${index++}次发送广播")
    }


    fun getLayoutId(): Int = R.layout.activity_main

}
