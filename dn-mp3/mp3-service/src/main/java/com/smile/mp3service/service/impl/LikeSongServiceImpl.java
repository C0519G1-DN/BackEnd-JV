package com.smile.mp3service.service.impl;

import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.entity.LikeSong;
import com.smile.mp3dao.repository.LikeSongRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.LikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LikeSongServiceImpl implements LikeSongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeSongRepository likeSongRepository;

    @Override
    public void likeSong(String username, int idSong, boolean isLike) {
        User user = userRepository.findByUsername(username);
        Song song = songRepository.findById(idSong).orElse(null);
        LikeSong likeSong = likeSongRepository.findByUserAndSong(user, song);
        if (likeSong == null) {
            likeSong = new LikeSong();
            likeSong.setUser(user);
            likeSong.setSong(song);
            likeSong.setLiked(isLike);
        } else {
            likeSong.setUser(user);
            likeSong.setSong(song);
            likeSong.setLiked(isLike);
        }
        System.out.println(isLike + " hai");
        likeSongRepository.save(likeSong);
    }

    @Override
    public boolean getLike(String username, int idSong) {
        User user = userRepository.findByUsername(username);
        Song song = songRepository.findById(idSong).orElse(null);
        LikeSong likeSong = likeSongRepository.findByUserAndSong(user, song);
        if (likeSong != null) {
            return likeSong.getLiked();
        }
        return false;
    }

//    @Override
//    public List<LikeSong> getTopLike() {
//        return likeSongRepository.findAllByUserAndSong(new PageRequest(0, 3));
//    }

    @Override
    public List<Object[]> getTotalLikeSong() {
//        Map ob1 = new HashMap();
        List<Object[]> songAndLike = likeSongRepository.totalLikeSong(new PageRequest(0, 3));
//        List<Object[]> aa = new ArrayList<>();
//        for (Object[] ob : songAndLike) {
//            Song key = (Song) ob[0];
//            System.out.println(key);
//            Long value = (Long) ob[1];
//            System.out.println(value);
//            aa.add(ob);
//        }
        System.out.println(songAndLike);
        return songAndLike;
    }
}

