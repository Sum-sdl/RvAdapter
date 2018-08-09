package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.sum.adapter.RecyclerDataHolder
import com.sum.adapter.sticky.StickRecyclerAdapter
import com.sum.adapter.sticky.StickyHeadDecoration
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

        val adapter = Stick()
        rv_simple.layoutManager = LinearLayoutManager(this)
        rv_simple.adapter = adapter
        rv_simple.setHasFixedSize(true)
        rv_simple.addItemDecoration(StickyHeadDecoration(adapter))

        // demo有bug 待排查
        val list = arrayListOf<RecyclerDataHolder<Any>>()
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(StickDataHolder("a"))
        list.add(NormalDataHolder("b"))
        list.add(NormalDataHolder("b"))
        list.add(NormalDataHolder("b"))
        list.add(NormalDataHolder("b"))
        list.add(NormalDataHolder("c"))
        list.add(NormalDataHolder("c"))
        list.add(NormalDataHolder("c"))
        list.add(NormalDataHolder("c"))
        list.add(NormalDataHolder("c"))
        list.add(NormalDataHolder("d"))
        list.add(NormalDataHolder("d"))
        adapter.dataHolders = list
    }

    private class Stick : StickRecyclerAdapter<Any>() {
        override fun onBindHeaderViewHolder(holder: View?, position: Int, data: Any?) {
            holder?.findViewById<TextView>(R.id.tv_index)?.text = "head->$position->$data"
        }

        override fun headLayoutId(): Int = R.layout.stick_head_view_item

        override fun headId(position: Int, data: Any?): Long = data.toString()[0].toUpperCase().toLong()
//        override fun headId(position: Int, data: Any?): Long = 1L
    }

}
