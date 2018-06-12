package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sum.lib.rvadapter.RecyclerAdapter
import com.sum.lib.rvadapter.RecyclerDataHolder
import com.sum.rvadapter.dataHolder.NormalDataHolder
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        val adapter = RecyclerAdapter<RecyclerDataHolder<*>>()
//        rv_simple.layoutManager = LinearLayoutManager(this)
        //高度自动计算的布局用来代替部分一次性展示场景
        //性能优化，最费时的是view实例化过程
        rv_simple.layoutManager = FullGridViewManager(this, 1)
        rv_simple.adapter = adapter
        rv_simple.isNestedScrollingEnabled = false


        btn_refresh2.setOnClickListener { rv_simple.layoutManager = FullGridViewManager(this, 3) }
        btn_refresh.setOnClickListener { adapter.notifyDataSetChanged() }

        //适配器添加统一类型的Item
        val list = arrayListOf<RecyclerDataHolder<*>>()
        for (i in 1..10) {
            list.add(NormalDataHolder(i))
        }
        adapter.setDataHolders(list)

    }
}
