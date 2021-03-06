package com.loosu.downloaddemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ProgressBar;

import com.liulishuo.okdownload.DownloadContext;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.StatusUtil;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.loosu.downloaddemo.R;
import com.loosu.downloaddemo.adapter.base.recyclerview.AbsRecyclerAdapter;
import com.loosu.downloaddemo.adapter.base.recyclerview.RecyclerHolder;

import java.io.File;

public class QueueDownloadAdapter extends AbsRecyclerAdapter {
    private static final String TAG = "QueueDownloadAdapter";

    private final Context mContext;
    private final DownloadContext mDownloadContext;


    public QueueDownloadAdapter(Context context) {
        mContext = context;
        final DownloadContext.QueueSet queueSet = new DownloadContext.QueueSet();
        queueSet.setParentPathFile(new File(context.getFilesDir(), "queue_download/"));
        queueSet.setMinIntervalMillisCallbackProcess(500);
        DownloadContext.Builder builder = queueSet.commit();

        String url1 = "http://dldir1.qq.com/weixin/android/weixin6516android1120.apk";
        DownloadTask task1 = builder.bind(url1);

        String url2 = "https://cdn.llscdn.com/yy/files/tkzpx40x-lls-LLS-5.7-785-20171108-111118.apk";
        DownloadTask task2 = builder.bind(url2);

        String url3 = "https://t.alipayobjects.com/L1/71/100/and/alipay_wap_main.apk";
        DownloadTask task3 = builder.bind(url3);

        String url4 = "https://dldir1.qq.com/qqfile/QQforMac/QQ_V6.2.0.dmg";
        DownloadTask task4 = builder.bind(url4);

        String url5 = "http://d1.music.126.net/dmusic/CloudMusic_official_4.3.2.468990.apk";
        DownloadTask task5 = builder.bind(url5);

        mDownloadContext = builder.build();
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_queue_download;
    }


    @Override
    protected void onBindViewData(RecyclerHolder holder, int position) {
        DownloadTask task = mDownloadContext.getTasks()[position];
        StatusUtil.Status status = StatusUtil.getStatus(task);
        BreakpointInfo info = StatusUtil.getCurrentInfo(task);

        String url = task.getUrl();
        holder.setText(R.id.tv_name, url.substring(url.lastIndexOf('/') + 1));
        holder.setText(R.id.tv_state, status.toString());

        if (info != null) {
            ProgressBar progressBar = holder.getView(R.id.progress);
            progressBar.setProgress((int) ((info.getTotalOffset() * 1f / info.getTotalLength()) * progressBar.getMax()));
        }
    }

    @Override
    public DownloadTask getItem(int position) {
        return mDownloadContext.getTasks()[position];
    }

    @Override
    public int getItemCount() {
        return mDownloadContext.getTasks().length;
    }

    public boolean isRunning() {
        return mDownloadContext.isStarted();
    }

    public void startAll(boolean isSerial) {
        mDownloadContext.start(mDownloadListener1, isSerial);
        notifyDataSetChanged();
    }

    public void stop() {
        mDownloadContext.stop();
        notifyDataSetChanged();
    }

    private DownloadListener1 mDownloadListener1 = new DownloadListener1() {

        @Override
        public void taskStart(@NonNull DownloadTask task, @NonNull Listener1Assist.Listener1Model model) {
            Log.i(TAG, "taskStart: task = " + task.getFilename() + ", model = " + model);
        }

        @Override
        public void retry(@NonNull DownloadTask task, @NonNull ResumeFailedCause cause) {
            Log.w(TAG, "retry: task = " + task.getFilename() + ", cause = " + cause);
        }

        @Override
        public void connected(@NonNull DownloadTask task, int blockCount, long currentOffset, long totalLength) {
            Log.i(TAG, "connected: task = " + task.getFilename() + ", blockCount = " + currentOffset);
        }

        @Override
        public void progress(@NonNull DownloadTask task, long currentOffset, long totalLength) {
            float precent = currentOffset * 100f / totalLength;
            Log.d(TAG, String.format("progress: task = %s ---- %.2f", task.getFilename(), precent));
            notifyDataSetChanged();
        }

        @Override
        public void taskEnd(@NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, @NonNull Listener1Assist.Listener1Model model) {
            Log.e(TAG, "taskEnd: task = " + task.getFilename() + ", cause = " + cause + ", realCause = " + realCause + ", model = " + model);
        }
    };

    public void startTask(int position) {
        mDownloadContext.getTasks()[position].enqueue(mDownloadListener1);
        notifyDataSetChanged();
    }

    public void stop(int position) {
        mDownloadContext.getTasks()[position].cancel();
        notifyDataSetChanged();
    }

    public void deleteAll() {
        DownloadTask[] tasks = mDownloadContext.getTasks();
        for (DownloadTask task : tasks) {
            File file = task.getFile();
            if (file != null) {
                file.delete();
            }
        }
    }
}
