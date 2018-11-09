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
import com.liulishuo.okdownload.StatusUtil;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;

import java.io.File;

public class SimpleDownloadActivity extends AppCompatActivity {
    private static final String TAG = "SimpleDownloadActivity";

    private static final String DIR_NAME = "simple_download/";

    private TextView mTvState;
    private ProgressBar mProgressBar;
    private TextView mBtnToggle;

    private DownloadTask mDownloadTask;
    private String mUrl;
    private File mDownloadFile;

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
        mUrl = "http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731o5sv2qj4jnaxqo7qute.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4n5JO6DhqYV4beEV0GFgVQHVM1H3pPAoTz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148zYEsEJ5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABAVnDw5Dt8ohCMbBwSuq%2B8yni5u70XWQhqk%2BR%2FZboR5%2F4Tl%2BsPYyF2l1IakH2ixYwVPygWg%2B1kOOQhe871mPV6B6QjyPe35LFYtC1MO%2BMZePJ7ZC9OmLMFpDKjoSlZoYl5IOy4dzkVpgPIAv%2BIW89aBZ1y%2FNZYjxW1mapP3GILP0%3D&OSSAccessKeyId=STS.NJLoT7ky4VuoUg4eTRXBk1VkC&Expires=1541759731&Signature=0z5pEESjDKbPa1tta4UAu62H9ww%3D";
        File parentDir = new File(getFilesDir(), DIR_NAME);
        if (!parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                Log.e(TAG, "创建文件夹-失败: " + parentDir);
            } else {
                Log.i(TAG, "创建文件夹-成功: " + parentDir);
            }
        }
        mDownloadFile = new File(parentDir.getParent(), "test.apk");
        //downloadFile.delete();
        mDownloadTask = new DownloadTask.Builder(mUrl, mDownloadFile)
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
        StatusUtil.Status status = StatusUtil.getStatus(mDownloadTask);
        BreakpointInfo info = StatusUtil.getCurrentInfo(mDownloadTask);
        String percent = "0.00%";
        long totalOffset = 0;
        long totalLength = 0;
        if (info != null) {
            totalOffset = info.getTotalOffset();
            totalLength = info.getTotalLength();

            percent = String.format("%.2f", totalOffset * 100f / totalLength);
        }
        StringBuffer sb = new StringBuffer()
                .append(status.toString()).append("\r\n")
                .append(percent).append("%").append("\r\n")
                .append(totalOffset).append('/').append(totalLength).append("\r\n");
        mTvState.setText(sb.toString());
    }

    private void initListener(Bundle savedInstanceState) {

    }

    public void onClick(View view) {
        StatusUtil.Status status = StatusUtil.getStatus(mDownloadTask);
        if (status.equals(StatusUtil.Status.RUNNING)) {
            mDownloadTask.cancel();
        } else {
            mDownloadTask.enqueue(mDownloadListener1);
        }
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
            String percent = String.format("%.2f", currentOffset * 100f / totalLength);
            StringBuffer sb = new StringBuffer()
                    .append("下载中...").append("\r\n")
                    .append(percent).append("%").append("\r\n")
                    .append(currentOffset).append('/').append(totalLength).append("\r\n");
            mTvState.setText(sb.toString());
            mProgressBar.setProgress((int) (currentOffset * 1f / totalLength * mProgressBar.getMax()));
        }

        @Override
        public void taskEnd(@NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, @NonNull Listener1Assist.Listener1Model model) {
            Log.w(TAG, "connected: task = " + task + ", cause = " + cause + ", realCause = " + realCause + ", model = " + model);
            if (cause.equals(EndCause.ERROR)) {
                mDownloadTask = new DownloadTask.Builder(mUrl, mDownloadFile)
                        // do re-download even if the task has already been completed in the past.
                        .setPassIfAlreadyCompleted(false)
                        .setMinIntervalMillisCallbackProcess(100)
                        .build();
            }
            mTvState.setText(cause.toString());
        }
    };
}
