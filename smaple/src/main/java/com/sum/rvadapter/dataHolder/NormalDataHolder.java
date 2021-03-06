package com.sum.rvadapter.dataHolder;

import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sum.adapter.RecyclerDataHolder;
import com.sum.adapter.RecyclerViewHolder;
import com.sum.rvadapter.R;

/**
 * Created by sdl on 2018/4/26.
 * 普通的list界面 item的一项
 */
public class NormalDataHolder extends RecyclerDataHolder<Object> {

    public NormalDataHolder(Object data) {
        super(data);
    }

    //一个type值，对应一组类型的ViewHolder，同一种内容的View
    // 多种不一样的Item，需要配置不一样的type，一个type对应一个内容View
    @Override
    public int getItemViewLayoutId() {//方便开发直接配置布局
        return R.layout.vh_normal_item;
    }

    //创建ViewHolder的内容，只会调用一定次数，超出屏幕的都是缓存的View
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View view, int i) {
        Log.e("tag", "onCreateViewHolder->" + i);
        return new ViewHolder(view);
    }

    //开发需要给每个缓存的View绑定数据
    @Override
    public void onBindViewHolder(int i, RecyclerView.ViewHolder viewHolder, Object o) {
        ViewHolder holder = (ViewHolder) viewHolder;
        //展示的数据源通过泛型Object传递给ViewHolder
        //TODO 给组合View设置参数操作;思考怎么避免重复操作
        holder.setData();
        Log.e("tag", "onBindViewHolder->" + i);
        holder.tv_index.setText("onBindViewHolder pos:" + i);
    }

    //该ViewHolder就是RecyclerView的每个内容View
    //TODO 可以理解成一个组合的View
    class ViewHolder extends RecyclerViewHolder {

        TextView tv_index;

        public ViewHolder(View view) {
            super(view);
            view.setTag(true);
            tv_index = findViewById(R.id.tv_index);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, " view.setTag(true)->" + getAdapterPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }

        public void setData() {
        }
    }
}
