package com.loosu.downloaddemo.download;

import com.loosu.downloaddemo.domain.MovieBean;

public interface IMovieDownloadManager {

    public void addTask(MovieBean movie, String file);

    public void removeTask(MovieBean movie);

}
