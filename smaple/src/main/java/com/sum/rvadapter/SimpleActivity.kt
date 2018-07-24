package com.sum.rvadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
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
        //性能优化，最费时的是view实例化过程和计算测量
        //经过测试，RecyclerView不需要手动设置布局高度，在NestedScrollView中高度设置warp_content即可
        //ScrollView中无效
        rv_simple.layoutManager = GridLayoutManager(this, 1)
        rv_simple.adapter = adapter
        rv_simple.isNestedScrollingEnabled = false


        btn_refresh2.setOnClickListener { rv_simple.layoutManager = GridLayoutManager(this, 3) }
        btn_refresh.setOnClickListener { adapter.notifyDataSetChanged() }

        //适配器添加统一类型的Item
        val list = arrayListOf<RecyclerDataHolder<*>>()
        for (i in 1..100) {
            list.add(NormalDataHolder(i))
        }
        adapter.setDataHolders(list)

        //TODO 该方法放大ViewHolder的缓存，在数据量大的时候，快速滚动的时候可以适当调整缓存的数量，充分利用缓存，减少view的动态创建
        //TODO 默认单个viewType缓存是5个，列表快速滚动的场景下，增加同类型type的缓存数量,很大提高view的复用
        //TODO 复用view的时候，注意数据源的是否相同，避免重复绘制数据源
        //TODO RecyclerDataHolder.updateData()方法更新数据源，参考适配器中的setHasStableIds讲解
        // setMaxRecycledViews
        rv_simple.recycledViewPool.setMaxRecycledViews(0, 100)

    }
}
