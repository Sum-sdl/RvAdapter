package com.sum.rvadapter.ui;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.sum.adapter.RecyclerDataHolder;
import com.sum.adapter.RecyclerViewHolder;
import com.sum.rvadapter.R;

/**
 * Created by sdl on 2020/9/3
 */
public class ColorHolder extends RecyclerDataHolder {
    public ColorHolder(Object data) {
        super(data);
    }

    @Override
    protected int getItemViewLayoutId() {
        return R.layout.vh_normal_item2;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(View itemView, int position) {
        return new RecyclerViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(int position, RecyclerView.ViewHolder viewHolder, Object data) {

    }
}
