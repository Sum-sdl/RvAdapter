package com.sum.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sdl on 2016/8/29.
 * 基础的ViewHolder
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public Context mContext;

    private View mRootView;

    public RecyclerViewHolder(View view) {
        super(view);
        mRootView = view;
        mContext = view.getContext();
    }

    public <T extends View> T findViewById(int id) {
        return mRootView.findViewById(id);
    }

    public int getColorByResId(int resId) {
        return ContextCompat.getColor(mContext, resId);
    }

}
