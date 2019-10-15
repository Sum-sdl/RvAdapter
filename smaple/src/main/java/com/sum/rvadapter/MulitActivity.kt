package com.sum.rvadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sum.adapter.RecyclerAdapter
import com.sum.adapter.RecyclerDataHolder
import com.sum.rvadapter.dataHolder.Normal2DataHolder
import com.sum.rvadapter.dataHolder.NormalDataHolder
import kotlinx.android.synthetic.main.activity_simple.*

class MulitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulit)


        val adapter = RecyclerAdapter()
        rv_simple.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rv_simple.adapter = adapter


        //适配器添加多个类型的Type
        val list = arrayListOf<RecyclerDataHolder<*>>()
        list.add(Normal2DataHolder(null))
        list.add(NormalDataHolder(null))
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
