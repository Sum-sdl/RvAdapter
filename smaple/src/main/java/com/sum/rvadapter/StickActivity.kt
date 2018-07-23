package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sum.lib.rvadapter.RecyclerAdapter
import com.sum.lib.rvadapter.RecyclerDataHolder
import com.sum.lib.rvadapter.sticky.StickyHeadDecoration
import com.sum.lib.rvadapter.sticky.StickyHeadView
import com.sum.rvadapter.dataHolder.NormalDataHolder
import com.sum.rvadapter.dataHolder.StickDataHolder
import kotlinx.android.synthetic.main.activity_simple.*

/**
 * Created by sdl on 2018/5/3.
 * 粘性列表集合
 */
class StickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulit)


        val adapter = RecyclerAdapter<RecyclerDataHolder<*>>()
        rv_simple.layoutManager = LinearLayoutManager(this)
        rv_simple.adapter = adapter
        rv_simple.addItemDecoration(StickyHeadDecoration(object : StickyHeadView {

            override fun onBindHeadView(view: View, p1: Int) {
                val res = adapter.dataHoders[p1].data
                val tv = view.findViewById<TextView>(R.id.tv_index)
                if (res is String) {
                    tv.text = "head:" + res
                } else {
                    tv.text = "head" + p1
                }
            }

            override fun getItemCount(): Int = adapter.itemCount

            override fun onCreateHeadView(p0: ViewGroup): View {
                return LayoutInflater.from(p0.context).inflate(R.layout.stick_head_view_item, p0, false)
            }

            override fun getHeadId(p0: Int): Long {//用来区分列表每一项的一类id
                return (adapter.dataHoders[p0].data as String)[0].toLong()
            }

            override fun firstHead(p0: Long, p1: Int) {

            }
        }))

        //适配器添加统一类型的Item
        val list = arrayListOf<RecyclerDataHolder<*>>()
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(NormalDataHolder("a"))
        list.add(NormalDataHolder("b"))
        list.add(NormalDataHolder("2"))
        list.add(NormalDataHolder("2"))
        list.add(StickDataHolder("2"))
        list.add(StickDataHolder("b"))
        list.add(StickDataHolder("b"))
        list.add(NormalDataHolder("3"))
        list.add(StickDataHolder("3"))
        list.add(StickDataHolder("3"))
        list.add(NormalDataHolder("3"))
        list.add(NormalDataHolder("3"))
        list.add(NormalDataHolder("3"))
        list.add(NormalDataHolder("4"))
        list.add(NormalDataHolder("4"))
        list.add(NormalDataHolder("4"))
        adapter.setDataHolders(list)
    }

}
