package com.loosu.downloaddemo;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.loosu.downloaddemo.adapter.recyclerview.ARecyclerAdapter;
import com.loosu.downloaddemo.adapter.recyclerview.RecyclerHolder;
import com.loosu.downloaddemo.domain.MovieBean;

import java.util.List;

public class MovieAdapter extends ARecyclerAdapter<MovieBean> {
    public MovieAdapter() {
        super(null);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_movie;
    }

    @Override
    protected void onBindViewData(RecyclerHolder holder, int position, List<MovieBean> datas) {
        MovieBean movieBean = getItem(position);

        holder.setText(R.id.tv_title, movieBean.getTitle());
        holder.setText(R.id.tv_username, movieBean.getUsername());

        ImageView ivCover = holder.getView(R.id.iv_cover);
        Glide.with(ivCover)
                .load(movieBean.getCover())
                .into(ivCover);
    }

    @Override
    public MovieBean getItem(int position) {
        return mDatas.get(position);
    }

    public void addDatas(List<MovieBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
}
