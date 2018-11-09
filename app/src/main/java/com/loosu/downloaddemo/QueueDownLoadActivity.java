package com.loosu.downloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.StatusUtil;
import com.loosu.downloaddemo.adapter.QueueDownloadAdapter;
import com.loosu.downloaddemo.adapter.recyclerview.IRecyclerItemClickListener;

public class QueueDownLoadActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, IRecyclerItemClickListener {

    private View mBtnStartOrStop;
    private View mBtnDeleteAll;
    private RadioGroup mRgOrder;
    private RecyclerView mViewList;

    QueueDownloadAdapter mDownloadAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_download);
        init(savedInstanceState);
        findView(savedInstanceState);
        initView(savedInstanceState);
        initListener(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        mDownloadAdapter = new QueueDownloadAdapter(this);
    }

    private void findView(Bundle savedInstanceState) {
        mBtnStartOrStop = (View) findViewById(R.id.btn_start_or_stop);
        mBtnDeleteAll = (View) findViewById(R.id.btn_delete_all);
        mRgOrder = (RadioGroup) findViewById(R.id.rg_order);
        mViewList = (RecyclerView) findViewById(R.id.view_list);
    }

    private void initView(Bundle savedInstanceState) {
        mViewList.setLayoutManager(new LinearLayoutManager(this));
        mViewList.setAdapter(mDownloadAdapter);
    }

    private void initListener(Bundle savedInstanceState) {
        mBtnStartOrStop.setOnClickListener(this);
        mBtnDeleteAll.setOnClickListener(this);
        mRgOrder.setOnCheckedChangeListener(this);
        mDownloadAdapter.setItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_or_stop:
                onClickStartOrStop();
                break;
            case R.id.btn_delete_all:
                break;
        }
    }

    private void onClickStartOrStop() {
        if (mDownloadAdapter.isRunning()) {
            mDownloadAdapter.stop();
        } else {
            boolean serial = mRgOrder.getCheckedRadioButtonId() == R.id.rb_serial;
            mDownloadAdapter.startAll(serial);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onItemClick(RecyclerView parent, int position, RecyclerView.ViewHolder holder, View view) {
        DownloadTask task = mDownloadAdapter.getItem(position);
        if (StatusUtil.getStatus(task) == StatusUtil.Status.RUNNING) {
            mDownloadAdapter.stop(position);
        }else{
            mDownloadAdapter.startTask(position);
        }
    }
}
