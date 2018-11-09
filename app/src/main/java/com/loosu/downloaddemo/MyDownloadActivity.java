package com.loosu.downloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.loosu.downloaddemo.domain.IndexCategoryResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyDownloadActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "MyDownloadActivity";

    private SwipeRefreshLayout mLayoutRefresh;
    private RecyclerView mMovieList;
    private RecyclerView mDownloadList;

    OkHttpClient mHttpClient = new OkHttpClient();

    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_download);
        init(savedInstanceState);
        findView(savedInstanceState);
        initView(savedInstanceState);
        initListener(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        mMovieAdapter = new MovieAdapter();
    }

    private void findView(Bundle savedInstanceState) {
        mLayoutRefresh = (SwipeRefreshLayout) findViewById(R.id.layout_refresh);
        mMovieList = (RecyclerView) findViewById(R.id.movie_list);
        mDownloadList = (RecyclerView) findViewById(R.id.download_list);
    }

    private void initView(Bundle savedInstanceState) {
        mMovieList.setLayoutManager(new LinearLayoutManager(this));
        mMovieList.setAdapter(mMovieAdapter);
        mDownloadList.setLayoutManager(new LinearLayoutManager(this));

        loadMovies(mMovieAdapter.getItemCount() / 10 + 1);
    }

    private void initListener(Bundle savedInstanceState) {
        mLayoutRefresh.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        loadMovies(mMovieAdapter.getItemCount() / 10 + 1);
    }

    private void loadMovies(int page) {
        mLayoutRefresh.setRefreshing(true);

        Request request = new Request.Builder()
                .url("http://test2.i-weiying.com/api/index_categoryList")
                .get()
                .build();
        HttpUrl.Builder urlBuilder = request.url().newBuilder()
                .addQueryParameter("sign", "TY-8da23798c69b7bf706604f25c2c9549ae21593b6bdf4be64")
                .addQueryParameter("ClientSource", "1")
                .addQueryParameter("ClientSystem", "1")
                .addQueryParameter("Version", "1")
                .addQueryParameter("mobile_unique_code", "1")
                .addQueryParameter("type", "hot")
                .addQueryParameter("page", String.valueOf(page));
        Request targetRequest = request.newBuilder()
                .url(urlBuilder.build())
                .build();

        Call call = mHttpClient.newCall(targetRequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mLayoutRefresh.setRefreshing(false);
                Log.e(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mLayoutRefresh.setRefreshing(false);
                Log.i(TAG, "onResponse: ");
                String responseStr = response.body().string();
                final IndexCategoryResponse indexCategoryResponse = JSONObject.parseObject(responseStr, IndexCategoryResponse.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mMovieAdapter.addDatas(indexCategoryResponse.getData());
                    }
                });
            }
        });
    }
}
