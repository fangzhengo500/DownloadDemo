package com.loosu.downloaddemo.download;

import com.liulishuo.okdownload.StatusUtil;
import com.loosu.downloaddemo.domain.MovieBean;

public interface IMovieDownloadManager {

    public enum Status {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN,         // may completed, but no filename can't ensure.
        NO_TASK,
    }

    public void addTask(MovieBean movie);

    public void addTask(MovieBean movie, String file);

    public void removeTask(MovieBean movie);

    public Status getTaskState(MovieBean movieBean);

    public void startTask(MovieBean movieBean);

    public void stopTask(MovieBean movieBean);

    public void startAll(boolean isSerial);

    public void stopAll();

}
