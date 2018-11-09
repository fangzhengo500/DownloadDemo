package com.loosu.downloaddemo.adapter.recyclerview;

import android.content.Context;
import android.util.SparseArray;

import java.util.List;

/**
 * @Author: ycl
 * @Date: 2018/10/29 16:32
 * @Desc:
 */
public abstract class CommonRecyclerViewAdapter<T> extends AbsRecyclerAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected final int mItemLayoutId;
    // 用来控制选中情况
    protected SparseArray<Boolean> isSelected = new SparseArray<Boolean>();


    public CommonRecyclerViewAdapter(Context context, List<T> datas, int itemLayoutId) {
        mContext = context;
        mDatas = datas;
        mItemLayoutId = itemLayoutId;
        initData();
    }

    private void initData() {
        if (isSelected == null) {
            isSelected = new SparseArray<Boolean>();
        }
        for (int i = 0; i < mDatas.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return mItemLayoutId;
    }

    @Override
    protected void onBindViewData(RecyclerHolder holder, int position) {
        onBindViewData(holder, position,getItem(position));
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }
    public abstract void onBindViewData(RecyclerHolder helper,  int position,T item);


    public SparseArray<Boolean> getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(SparseArray<Boolean> isSelected) {
        this.isSelected = isSelected;
    }
}
