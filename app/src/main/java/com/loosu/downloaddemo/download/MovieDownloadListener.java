package com.loosu.downloaddemo.download;

import android.support.annotation.NonNull;

public interface MovieDownloadListener {
    public void taskEnd(@NonNull IMovieDownloadManager manager);

    public void queueEnd(@NonNull IMovieDownloadManager manager);
}
