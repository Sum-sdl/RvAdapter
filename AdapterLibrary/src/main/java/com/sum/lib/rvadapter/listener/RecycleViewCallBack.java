package com.sum.lib.rvadapter.listener;

/**
 * @author Sum
 * @date 15/11/27
 */
public interface RecycleViewCallBack<T> {

    /**
     * @param position 数据源位置
     * @param data     对应数据项
     */
    void onItemClick(int position, T data);

}
