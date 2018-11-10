package com.loosu.downloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.StatusUtil;
import com.loosu.downloaddemo.adapter.QueueDownloadAdapter;
import com.loosu.downloaddemo.adapter.base.recyclerview.IRecyclerItemClickListener;

public class QueueDownLoadActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, IRecyclerItemClickListener {

    private Button mBtnStartOrStop;
    private Button mBtnDeleteAll;
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
        mBtnStartOrStop = (Button) findViewById(R.id.btn_start_or_stop);
        mBtnDeleteAll = (Button) findViewById(R.id.btn_delete_all);
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
                onClickDeleteAll();
                break;
        }
    }

    private void onClickDeleteAll() {
        mDownloadAdapter.deleteAll();
    }

    private void onClickStartOrStop() {
        if (mDownloadAdapter.isRunning()) {
            mDownloadAdapter.stop();
            mBtnStartOrStop.setText("全部开始");
        } else {
            boolean serial = mRgOrder.getCheckedRadioButtonId() == R.id.rb_serial;
            mDownloadAdapter.startAll(serial);
            mBtnStartOrStop.setText("全部暂停");
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
            Toast.makeText(this, "暂停: " + task.getFilename(), Toast.LENGTH_SHORT).show();
        } else {
            mDownloadAdapter.startTask(position);
            Toast.makeText(this, "开始: " + task.getFilename(), Toast.LENGTH_SHORT).show();
        }
    }
}
