package com.sum.rvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sdl on 2016/8/29.
 * 统一预处理的数据源,对应一个缓存中的ViewType
 */
public abstract class RecyclerDataHolder<T> {

    private T mData;
    private int mId;

    public RecyclerDataHolder(T data) {
        mData = data;
        mId = super.hashCode();
    }

    public int getId() {
        return mId;
    }

    public abstract int getItemViewLayoutId();

    //统一创建viewHolder的content view
    public View onCreateView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(getItemViewLayoutId(), parent, false);
    }

    public abstract ViewHolder onCreateViewHolder(View itemView, int position);

    public abstract void onBindViewHolder(int position, ViewHolder vHolder, T data);

    public int getType() {
        return 0;
    }

    public T getData() {
        return mData;
    }
}
