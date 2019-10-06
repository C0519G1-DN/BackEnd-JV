package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.ResCommentPlaylist;
import com.smile.mp3dao.dto.SocialCommentPlaylistDTO;
import com.smile.mp3dao.entity.*;
import com.smile.mp3dao.repository.PlaylistRepository;
import com.smile.mp3dao.repository.SocialCommentPlaylistRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.SocialCommentPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SocialCommentPlaylistServiceImpl implements SocialCommentPlaylistService {

    @Autowired
    public SocialCommentPlaylistRepository socialCommentPlaylistRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PlaylistRepository playlistRepository;

    @Override
    public List<ResCommentPlaylist> findAll(int idPlaylist) {
        List <SocialCommentPlaylist> list = socialCommentPlaylistRepository.findAllByPlaylists_Id(idPlaylist);
        List<ResCommentPlaylist> res = new ArrayList<>();

        for(SocialCommentPlaylist element:list){
            res.add(new ResCommentPlaylist(element.getUsers().getUsername(),element.getComment(),element.getCreateDate()));
        }
        return res;

    }

    @Override
    public void saveSCP(SocialCommentPlaylistDTO req) {
        SocialCommentPlaylist socialCommentPlaylist = new SocialCommentPlaylist();
        User myUser = userRepository.findById(req.getUsers_id()).orElse(null);
        Playlist myPlaylist = playlistRepository.findById(req.getPlaylists_id()).orElse(null);
        Date date= new Date();

        socialCommentPlaylist.setComment(req.getComment());
        socialCommentPlaylist.setPlaylists(myPlaylist);
        socialCommentPlaylist.setUsers(myUser);
        socialCommentPlaylist.setCreateDate(date);

        socialCommentPlaylistRepository.save(socialCommentPlaylist);

    }
}
