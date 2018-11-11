package com.loosu.downloaddemo.download;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.loosu.downloaddemo.domain.MovieBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MovieDownloadManager implements IMovieDownloadManager {
    private static final String TAG = "MovieDownloadManager";

    private static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(
            0,
            Integer.MAX_VALUE,
            30, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            Util.threadFactory("MovieDownloadManager Serial", false));

    private static IMovieDownloadManager mInstance;

    private final Context mContext;
    private List<MovieTask> mMovieTasks = new ArrayList<>();
    private volatile boolean isStarted = false;
    private final QueueSet mQueueSet;
    private Handler mUiHandler;

    private MovieDownloadManager(@NonNull Context context,
                                 @NonNull QueueSet set,
                                 @NonNull Handler uiHandler) {
        mContext = context;
        mQueueSet = set;
        mUiHandler = uiHandler;
    }

    public static IMovieDownloadManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (MovieDownloadManager.class) {
                if (mInstance == null) {
                    QueueSet queueSet = new QueueSet()
                            .setParentPathFile(context.getFilesDir());
                    mInstance = new MovieDownloadManager(context, queueSet, null);
                }
            }
        }
        return mInstance;
    }

    public boolean isStarted() {
        return isStarted;
    }


    @Override
    public void addTask(MovieBean movie) {
        DownloadTask downloadTask = new DownloadTask.Builder(movie.getMedia(), mQueueSet.getParentDirUri())
                .setFilenameFromResponse(true)
                .setMinIntervalMillisCallbackProcess(mQueueSet.getMinIntervalMillisCallbackProcess())
                .build();
        MovieTask movieTask = new MovieTask(movie, downloadTask);
        mMovieTasks.add(movieTask);
    }

    @Override
    public void addTask(MovieBean movie, String file) {
        DownloadTask downloadTask = new DownloadTask.Builder(movie.getMedia(), new File(file))
                .setMinIntervalMillisCallbackProcess(mQueueSet.getMinIntervalMillisCallbackProcess())
                .build();
        MovieTask movieTask = new MovieTask(movie, downloadTask);
        mMovieTasks.add(movieTask);
    }

    @Override
    public void removeTask(MovieBean movie) {
        ListIterator<MovieTask> iterator = mMovieTasks.listIterator();
        while (iterator.hasNext()) {
            MovieTask movieTask = iterator.next();
            if (movie.equals(movieTask.getMovie())) {
                movieTask.getDownloadTask().cancel();
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public Status getTaskState(MovieBean movieBean) {
        return Status.IDLE;
    }

    @Override
    public void startTask(MovieBean movieBean) {
        for (MovieTask movieTask : mMovieTasks) {
            if (movieTask.getMovie().equals(movieBean)) {
                movieTask.getDownloadTask().enqueue(mDownloadListener1);
                return;
            }
        }
    }

    @Override
    public void stopTask(MovieBean movieBean) {

    }

    @Override
    public void startAll(boolean isSerial) {
        isStarted = true;

        if (isSerial) {
            executeOnSerialExecutor(new Runnable() {
                @Override
                public void run() {
                    for (MovieTask movieTask : mMovieTasks) {
                        movieTask.getDownloadTask().enqueue(mDownloadListener1);
                    }
                }
            });
        } else {
            DownloadTask[] tasks = new DownloadTask[mMovieTasks.size()];
            for (int i = 0; i < mMovieTasks.size(); i++) {
                tasks[i] = mMovieTasks.get(i).getDownloadTask();
            }
            DownloadTask.enqueue(tasks, mDownloadListener1);
        }
    }

    @Override
    public void stopAll() {
        DownloadTask[] tasks = new DownloadTask[mMovieTasks.size()];
        for (int i = 0; i < mMovieTasks.size(); i++) {
            tasks[i] = mMovieTasks.get(i).getDownloadTask();
        }
        OkDownload.with().downloadDispatcher().cancel(tasks);
    }

    private void executeOnSerialExecutor(Runnable runnable) {
        SERIAL_EXECUTOR.execute(runnable);
    }

    public static class QueueSet {
        private Map<String, List<String>> mHeaderMapFileds;
        private Uri mParentDirUri;
        private Integer mReadBufferSize;
        private Integer mFlushBufferSize;
        private Integer mSyncBufferSize;
        private Integer mSyncBufferIntervalMillis;

        private Boolean isAutoCallbackToUIThread;
        private Integer mMinIntervalMillsCallbackProcess;

        private Boolean isPassIfAlreadyCompleted;
        private Boolean isWifiRequired;

        private Object mTag;

        public Map<String, List<String>> getHeaderMapFileds() {
            return mHeaderMapFileds;
        }

        public QueueSet setHeaderMapFileds(Map<String, List<String>> headerMapFileds) {
            mHeaderMapFileds = headerMapFileds;
            return this;
        }

        public Uri getParentDirUri() {
            return mParentDirUri;
        }

        public QueueSet setParentDirUri(@NonNull Uri parentDirUri) {
            mParentDirUri = parentDirUri;
            return this;
        }

        public QueueSet setParentPathFile(@NonNull File parentPathFile) {
            if (parentPathFile.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }

            mParentDirUri = Uri.fromFile(parentPathFile);
            return this;
        }

        public QueueSet setParentPath(@NonNull String parentPath) {
            return setParentPathFile(new File(parentPath));
        }

        public int getReadBufferSize() {
            return mReadBufferSize == null ? DownloadTask.Builder.DEFAULT_READ_BUFFER_SIZE : mReadBufferSize;
        }

        public QueueSet setReadBufferSize(int readBufferSize) {
            mReadBufferSize = readBufferSize;
            return this;
        }

        public boolean isWifiRequired() {
            return isWifiRequired == null ? DownloadTask.Builder.DEFAULT_IS_WIFI_REQUIRED : isWifiRequired;
        }

        public QueueSet setWifiRequired(boolean wifiRequired) {
            isWifiRequired = wifiRequired;
            return this;
        }

        public int getFlushBufferSize() {
            return mFlushBufferSize == null ? DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE : mFlushBufferSize;
        }

        public QueueSet setFlushBufferSize(int flushBufferSize) {
            mFlushBufferSize = flushBufferSize;
            return this;
        }

        public int getSyncBufferSize() {
            return mSyncBufferSize == null ? DownloadTask.Builder.DEFAULT_SYNC_BUFFER_SIZE : mSyncBufferSize;
        }

        public QueueSet setSyncBufferSize(int syncBufferSize) {
            mSyncBufferSize = syncBufferSize;
            return this;
        }

        public int getSyncBufferIntervalMillis() {
            return mSyncBufferIntervalMillis == null ? DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS : mSyncBufferIntervalMillis;
        }

        public QueueSet setSyncBufferIntervalMillis(int syncBufferIntervalMillis) {
            mSyncBufferIntervalMillis = syncBufferIntervalMillis;
            return this;
        }

        public boolean isAutoCallbackToUIThread() {
            return isAutoCallbackToUIThread == null ? DownloadTask.Builder.DEFAULT_AUTO_CALLBACK_TO_UI_THREAD : isAutoCallbackToUIThread;
        }

        public QueueSet setAutoCallbackToUIThread(boolean autoCallbackToUIThread) {
            isAutoCallbackToUIThread = autoCallbackToUIThread;
            return this;
        }

        public int getMinIntervalMillisCallbackProcess() {
            return mMinIntervalMillsCallbackProcess == null ? DownloadTask.Builder.DEFAULT_MIN_INTERVAL_MILLIS_CALLBACK_PROCESS : mMinIntervalMillsCallbackProcess;
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer minIntervalMillisCallbackProcess) {
            mMinIntervalMillsCallbackProcess = minIntervalMillisCallbackProcess;
            return this;
        }

        public boolean isPassIfAlreadyCompleted() {
            return isPassIfAlreadyCompleted == null ? DownloadTask.Builder.DEFAULT_PASS_IF_ALREADY_COMPLETED : isPassIfAlreadyCompleted;
        }

        public QueueSet setPassIfAlreadyCompleted(boolean passIfAlreadyCompleted) {
            isPassIfAlreadyCompleted = passIfAlreadyCompleted;
            return this;
        }

        public Object getTag() {
            return mTag;
        }

        public QueueSet setTag(Object tag) {
            mTag = tag;
            return this;
        }
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
        }

        @Override
        public void taskEnd(@NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, @NonNull Listener1Assist.Listener1Model model) {
            Log.e(TAG, "taskEnd: task = " + task.getFilename() + ", cause = " + cause + ", realCause = " + realCause + ", model = " + model);
        }
    };
}
