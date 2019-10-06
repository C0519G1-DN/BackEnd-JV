package com.smile.mp3service.service;

import com.smile.mp3dao.dto.ReqAddLikePlaylist;

public interface SocialLikePlaylistService {

    Long getTotallike(int idPlaylist);
//    List<SocialLikePlaylist> findAll();

    Boolean getDoLikeByUserWithPlaylist(int idUser, int idPlaylist);

    void saveSLP(ReqAddLikePlaylist req);


}
