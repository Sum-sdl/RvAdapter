package com.sum.rvadapter.dataHolder;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sum.adapter.RecyclerDataHolder;
import com.sum.adapter.RecyclerViewHolder;
import com.sum.rvadapter.R;

/**
 * Created by sdl on 2018/5/2.
 */
public class Normal2DataHolder extends RecyclerDataHolder<Object> {

    public Normal2DataHolder(Object data) {
        super(data);
    }

    @Override
    public int getItemViewLayoutId() {//方便开发直接配置布局
        return R.layout.vh_normal2_item;
    }

    //创建ViewHolder的内容，只会调用一定次数，超出屏幕的都是缓存的View
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(View view, int i) {
        return new ViewHolder(view);
    }

    //开发需要给每个缓存的View绑定数据
    @Override
    public void onBindViewHolder(int i, RecyclerView.ViewHolder viewHolder, Object o) {
        ViewHolder holder = (ViewHolder) viewHolder;
        //展示的数据源通过泛型Object传递给ViewHolder
        //TODO 给组合View设置参数操作;思考怎么避免重复操作
        holder.setData();

//        holder.tv_index.setText("DataHolder2 onBindViewHolder POS:" + i);
    }

    //该ViewHolder就是RecyclerView的每个内容View
    //TODO 可以理解成一个组合的View
    class ViewHolder extends RecyclerViewHolder {

        TextView tv_index;

        public ViewHolder(View view) {
            super(view);
            tv_index = findViewById(R.id.tv_index);
        }

        public void setData() {
            setTextViewText(R.id.tv_index, "Hell0000000");
        }
    }
}
