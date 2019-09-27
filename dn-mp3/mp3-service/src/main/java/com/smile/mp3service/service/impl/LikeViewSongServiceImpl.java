package com.smile.mp3service.service.impl;

import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.entity.LikeSong;
import com.smile.mp3dao.repository.LikeViewSongRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.LikeViewSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeViewSongServiceImpl implements LikeViewSongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeViewSongRepository likeViewSongRepository;

    @Override
    public void likeSong(String username, int idSong, boolean isLike) {
        User user = userRepository.findByUsername(username);
        Song song = songRepository.findById(idSong).orElse(null);
        LikeSong likeSong = likeViewSongRepository.findByUserAndSong(user, song);
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
        likeViewSongRepository.save(likeSong);
    }

    @Override
    public boolean getLike(String username, int idSong) {
        User user = userRepository.findByUsername(username);
        Song song = songRepository.findById(idSong).orElse(null);
        LikeSong likeSong = likeViewSongRepository.findByUserAndSong(user, song);
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
        List<Object[]> songAndLike = likeViewSongRepository.totalLikeSong(new PageRequest(0, 4));
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

    @Override
    public int getLikeOfSong(int idSong) {
        Song song1 = songRepository.findById(idSong).orElse(null);
        return likeViewSongRepository.getLikeOfSong(song1);
//      cach2:  return likeViewSongRepository.countByLikedIsTrueAndSong_Id(idSong);
    }

    @Override
    public int viewSong(int idSong) {
        Song song = songRepository.findById(idSong).orElse(null);
        song.setView_song(song.getView_song() + 1);
        songRepository.save(song);
        return song.getView_song();
    }
}

