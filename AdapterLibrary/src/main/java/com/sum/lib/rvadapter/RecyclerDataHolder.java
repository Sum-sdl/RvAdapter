package com.sum.lib.rvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 统一预处理的数据源,对应一个缓存中的ViewType
 *
 * @author sdl
 * @date 2016/8/29
 */
public abstract class RecyclerDataHolder<T> {

    private T mData;
    private int mId;
    private RecyclerAdapter mAdapter;

    public RecyclerDataHolder(T data) {
        mData = data;
        mId = super.hashCode();
    }

    public int getId() {
        return mId;
    }

    /**
     * 列表item的layout布局id
     */
    protected abstract int getItemViewLayoutId();

    View onCreateView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(getItemViewLayoutId(), parent, false);
    }

    protected abstract ViewHolder onCreateViewHolder(View itemView, int position);

    protected abstract void onBindViewHolder(int position, ViewHolder viewHolder, T data);

    void addRecyclerAdapter(RecyclerAdapter adapter) {
        mAdapter = adapter;
    }

    protected RecyclerAdapter getRecyclerAdapter() {
        return mAdapter;
    }

     int getType() {
        return getItemViewLayoutId();
    }

    public T getData() {
        return mData;
    }

    public void updateData(T newData) {
        mData = newData;
    }
}
