package com.loosu.downloaddemo.download;

import com.liulishuo.okdownload.DownloadTask;
import com.loosu.downloaddemo.domain.MovieBean;

public class MovieTask {
    private final MovieBean mMovie;
    private final DownloadTask mDownloadTask;

    public MovieTask(MovieBean movie, DownloadTask downloadTask) {
        mMovie = movie;
        mDownloadTask = downloadTask;
    }

    public MovieBean getMovie() {
        return mMovie;
    }

    public DownloadTask getDownloadTask() {
        return mDownloadTask;
    }
}
