package com.smile.mp3service.service;

import com.smile.mp3dao.entity.LikeSong;

import java.util.List;
import java.util.Map;

public interface   LikeSongService {

    void likeSong(String username, int idSong, boolean isLike);

    boolean getLike(String username, int idSong);

//    List<LikeSong> getTopLike();

    List<Object[]> getTotalLikeSong();
}
