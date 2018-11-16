package com.sum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    boolean mHasBindView = false;

    public RecyclerDataHolder(T data) {
        mData = data;
        mId = super.hashCode();
    }

    /**
     * 用来设置RecyclerView的getItemId，跟Rv里面的mHasStableIds有关
     */
    protected int getId() {
        return mId;
    }

    /**
     * onBindViewHolder只执行一次(适用于一个单个view对应一个数据项，可以避免item每次可见的时候刷新)
     */
    protected boolean isSingleBindView() {
        return false;
    }

    /**
     * 列表item的layout布局id
     */
    protected abstract int getItemViewLayoutId();

    protected abstract RecyclerView.ViewHolder onCreateViewHolder(View itemView, int position);

    protected abstract void onBindViewHolder(int position, RecyclerView.ViewHolder viewHolder, T data);

    protected View onCreateView(Context context, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(getItemViewLayoutId(), parent, false);
    }

    void addRecyclerAdapter(RecyclerAdapter adapter) {
        mAdapter = adapter;
    }

    protected RecyclerAdapter getRecyclerAdapter() {
        return mAdapter;
    }

    protected int getType() {
        return getItemViewLayoutId();
    }

    public T getData() {
        return mData;
    }

    public RecyclerDataHolder updateData(T newData) {
        mData = newData;
        mHasBindView = false;
        return this;
    }

    public void resetBindView() {
        mHasBindView = false;
    }
}
