package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sum.lib.rvadapter.RecyclerAdapter
import com.sum.lib.rvadapter.RecyclerDataHolder
import com.sum.rvadapter.dataHolder.NormalDataHolder
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        val adapter = RecyclerAdapter<RecyclerDataHolder<*>>()
        rv_simple.layoutManager = LinearLayoutManager(this)
        rv_simple.adapter = adapter


        //适配器添加统一类型的Item
        val list = arrayListOf<RecyclerDataHolder<*>>()
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        adapter.setDataHolders(list)

    }
}
