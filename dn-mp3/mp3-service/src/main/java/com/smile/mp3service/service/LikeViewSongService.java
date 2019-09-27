package com.smile.mp3service.service;

import java.util.List;

public interface LikeViewSongService {

    void likeSong(String username, int idSong, boolean isLike);

    boolean getLike(String username, int idSong);

//    List<LikeSong> getTopLike();

    List<Object[]> getTotalLikeSong();

    int getLikeOfSong(int idSong);

    int viewSong(int idSong);
}
