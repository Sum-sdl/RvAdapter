package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sum.adapter.RecyclerAdapter
import com.sum.adapter.RecyclerDataHolder
import com.sum.rvadapter.dataHolder.Normal2DataHolder
import com.sum.rvadapter.dataHolder.NormalDataHolder
import kotlinx.android.synthetic.main.activity_simple.*

class MulitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulit)


        val adapter = RecyclerAdapter<RecyclerDataHolder<*>>()
        rv_simple.layoutManager = LinearLayoutManager(this)
        rv_simple.adapter = adapter


        //适配器添加多个类型的Type
        val list = arrayListOf<RecyclerDataHolder<*>>()
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        list.add(NormalDataHolder(null))
        adapter.setDataHolders(list)

    }

}
