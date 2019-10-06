package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.ReqAddLikePlaylist;
import com.smile.mp3dao.entity.SocialLikePlaylist;
import com.smile.mp3dao.repository.PlaylistRepository;
import com.smile.mp3dao.repository.SocialLikePlaylistRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.SocialLikePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialLikePlaylistServiceImpl implements SocialLikePlaylistService {

    @Autowired
    public SocialLikePlaylistRepository socialLikePlaylistRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PlaylistRepository playlistRepository;



    @Override
    public Long getTotallike(int idPlaylist) {
        return socialLikePlaylistRepository.countByLikedIsTrueAndPlaylists_Id(idPlaylist);
//        return null;
    }

//    @Override
//    public List<SocialLikePlaylist> findAll() {
//        return socialLikePlaylistRepository.findAllByLikedIsFalse();
//    }


//    @Override
//    public Long getTotallike(int idPlaylist) {
//        Playlist myPlaylist = playlistRepository.findById(idPlaylist).orElse(null);
//        return socialLikePlaylistRepository.countByLikedIsTrueAndPlaylists(myPlaylist);
//    }


    @Override
    public Boolean getDoLikeByUserWithPlaylist(int idUser, int idPlaylist) {
        if(
            socialLikePlaylistRepository.findSocialLikePlaylistsByUsers_IdAndAndPlaylists_Id(idUser, idPlaylist) == null){
            return false;
        }
        return socialLikePlaylistRepository.findSocialLikePlaylistsByUsers_IdAndAndPlaylists_Id(idUser, idPlaylist).getLiked();
    }

    @Override
    public void saveSLP(ReqAddLikePlaylist req) {
        SocialLikePlaylist socialLikePlaylist = new SocialLikePlaylist();
        socialLikePlaylist.setLiked(req.getLiked());
        socialLikePlaylist.setPlaylists(playlistRepository.findById(req.getPlaylists_id()).orElse(null));
        socialLikePlaylist.setUsers(userRepository.findById(req.getUsers_id()).orElse(null));
        socialLikePlaylistRepository.save(socialLikePlaylist);
    }


}
