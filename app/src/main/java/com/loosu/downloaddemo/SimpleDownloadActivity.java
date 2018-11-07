package com.loosu.downloaddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.DownloadListener3;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;

import java.io.File;

public class SimpleDownloadActivity extends AppCompatActivity {
    private static final String TAG = "SimpleDownloadActivity";

    private static final String DIR_NAME = "simple_download/";

    private TextView mTvState;
    private ProgressBar mProgressBar;
    private TextView mBtnToggle;

    private DownloadTask mDownloadTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_download);
        init(savedInstanceState);
        findView(savedInstanceState);
        initView(savedInstanceState);
        initListener(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        String url = "https://cdn.llscdn.com/yy/files/xs8qmxn8-lls-LLS-5.8-800-20171207-111607.apk";
        File parentDir = new File(getFilesDir(), DIR_NAME);
        if (!parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                Log.e(TAG, "创建文件夹-失败: " + parentDir);
            } else {
                Log.i(TAG, "创建文件夹-成功: " + parentDir);
            }
        }
        // do re-download even if the task has already been completed in the past.
        mDownloadTask = new DownloadTask.Builder(url, parentDir.getAbsolutePath(), "test.apk")
                // do re-download even if the task has already been completed in the past.
                .setPassIfAlreadyCompleted(false)
                .setMinIntervalMillisCallbackProcess(100)
                .build();
    }

    private void findView(Bundle savedInstanceState) {
        mTvState = (TextView) findViewById(R.id.tv_state);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mBtnToggle = (TextView) findViewById(R.id.btn_toggle);
    }

    private void initView(Bundle savedInstanceState) {
    }

    private void initListener(Bundle savedInstanceState) {

    }

    public void onClick(View view) {
        mDownloadTask.enqueue(mDownloadListener1);
    }

    private DownloadListener1 mDownloadListener1 = new DownloadListener1() {
        @Override
        public void taskStart(@NonNull DownloadTask task, @NonNull Listener1Assist.Listener1Model model) {
            Log.i(TAG, "taskStart: task = " + task + ", model = " + model);
            mTvState.setText("开始下载...");
        }

        @Override
        public void retry(@NonNull DownloadTask task, @NonNull ResumeFailedCause cause) {
            Log.d(TAG, "retry: task = " + task + ", cause = " + cause);
        }

        @Override
        public void connected(@NonNull DownloadTask task, int blockCount, long currentOffset, long totalLength) {
            Log.w(TAG, "connected: task = " + task + ", blockCount = " + blockCount);
        }

        @Override
        public void progress(@NonNull DownloadTask task, long currentOffset, long totalLength) {
            Log.d(TAG, "progress: task = " + task + ", currentOffset = " + currentOffset + ", totalLength = " + totalLength + " " + currentOffset * 1f / totalLength + " %");
            double percent = currentOffset * 1f / totalLength;
            StringBuffer sb = new StringBuffer()
                    .append("下载中...").append("\r\n")
                    .append(percent * 100).append("%").append("\r\n")
                    .append(currentOffset).append('/').append(totalLength).append("\r\n");
            mTvState.setText(sb.toString());
            mProgressBar.setProgress((int) (currentOffset * 1f / totalLength * mProgressBar.getMax()));
        }

        @Override
        public void taskEnd(@NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, @NonNull Listener1Assist.Listener1Model model) {
            Log.w(TAG, "connected: task = " + task + ", cause = " + cause + ", realCause = " + realCause + ", model = " + model);
        }
    };
}
