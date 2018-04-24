package com.sum.rvadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by sdl on 2017/12/29.
 */
public class RecyclerAdapter<DataHolder extends RecyclerDataHolder> extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext = null;
    private List<DataHolder> mHolders;
    private int mCurPosition;

    public RecyclerAdapter(Context context) {
        this(context, null);
        mHolders = new ArrayList<>();
    }

    public RecyclerAdapter(Context context, List<DataHolder> holders) {
        if (context == null)
            throw new NullPointerException();
        mContext = context;
        if (holders != null) {
            mHolders = new ArrayList<>(holders.size() + 10);
            mHolders.addAll(holders);
        }
        setHasStableIds(true);
    }

    public void setDataHolders(List<DataHolder> holders) {
        if (holders == null)
            mHolders = new ArrayList<>();
        else {
            mHolders = new ArrayList<>(holders.size() + 10);
            mHolders.addAll(holders);
        }
        notifyDataSetChanged();
    }

    public void addDataHolder(DataHolder holder) {
        mHolders.add(holder);
        notifyItemInserted(mHolders.size() - 1);
    }

    public void addDataHolder(int location, DataHolder holder) {
        mHolders.add(location, holder);
        notifyItemInserted(location);
    }

    public void addDataHolder(List<DataHolder> holders) {
        int location = mHolders.size();
        mHolders.addAll(holders);
        notifyItemRangeInserted(location, holders.size());
    }

    public void addDataHolder(int location, List<DataHolder> holders) {
        mHolders.addAll(location, holders);
        notifyItemRangeInserted(location, holders.size());
    }

    public void removeDataHolder(int location) {
        if (location < mHolders.size()) {
            mHolders.remove(location);
            notifyItemRemoved(location);
        }
    }

    public void removeDataHolder(DataHolder holder) {
        int index = mHolders.indexOf(holder);
        if (index != -1) {
            mHolders.remove(index);
            notifyItemRemoved(index);
        }
    }

    public DataHolder queryDataHolder(int location) {
        return mHolders.get(location);
    }

    public int queryDataHolder(DataHolder holder) {
        return mHolders.indexOf(holder);
    }

    @Override
    public final int getItemCount() {
        return mHolders.size();
    }

    @Override
    public final long getItemId(int position) {
        return queryDataHolder(position).getId();
    }

    @Override
    public final int getItemViewType(int position) {
        mCurPosition = position;
        return queryDataHolder(position).getType();
    }

    @Override
    public final ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerDataHolder<DataHolder> holder = queryDataHolder(mCurPosition);
        View view = holder.onCreateView(mContext, parent);
        return holder.onCreateViewHolder(view, mCurPosition);
    }

    @Override
    public final void onBindViewHolder(ViewHolder arg0, int position) {
        RecyclerDataHolder<DataHolder> holder = queryDataHolder(position);
        holder.onBindViewHolder(mContext, position, arg0, holder.getData());
    }

}
