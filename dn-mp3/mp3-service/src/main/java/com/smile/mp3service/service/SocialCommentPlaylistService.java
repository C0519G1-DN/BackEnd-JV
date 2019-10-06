package com.smile.mp3service.service;

import com.smile.mp3dao.dto.SocialCommentPlaylistDTO;
import com.smile.mp3dao.dto.ResCommentPlaylist;

import java.util.List;

public interface SocialCommentPlaylistService {

    List<ResCommentPlaylist> findAll(int idPlaylist);


    void saveSCP(SocialCommentPlaylistDTO req);


}
