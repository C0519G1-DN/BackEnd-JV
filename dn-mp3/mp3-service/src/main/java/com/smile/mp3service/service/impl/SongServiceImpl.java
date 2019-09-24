package com.smile.mp3service.service.impl;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.LikeSong;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SingerRepository singerRepository;

    @Autowired private UserRepository userRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public void saveSong(SongDTO songDTO){
        MultipartFile fSong = songDTO.getFile_song();
        MultipartFile iSong = songDTO.getImg_song();
        Date date= new Date();
        Song theSong = new Song(songDTO);
        theSong.setLink_song("assets\\"+fSong.getOriginalFilename());
        theSong.setLink_img_song("assets\\"+iSong.getOriginalFilename());
        theSong.setView_song(0);
        theSong.setCreateDate(date);
        theSong.setDelected(false);

        Singer theSinger = singerRepository.findByName("Unknowing");
                if(theSinger == null){
                    theSinger = new Singer("Unknowing", "https://gspzone.hvazone.com/sodiz/adminlte/img/unknown-user.png");
                    singerRepository.save(theSinger);}
        Set<Singer> set = theSong.getSingers();
        set.add(theSinger);
        theSong.setSingers(set);

        songRepository.save(theSong);

    }

    @Override
    public void saveSongWithSinger(int idSong, int idSinger) {
        Song theSong = songRepository.findById(idSong).orElse(null);
        Singer theSinger = singerRepository.findById(idSinger).orElse(null);
        Set<Singer> set = theSong.getSingers();
        set.add(theSinger);
        theSong.setSingers(set);
        songRepository.save(theSong);
    }

    @Override
    public Song getSong(int id) {

        return songRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteSong(int id) throws ResourceNotFoundException {
        Song songItem = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found this id: " + id));
        songItem.setDelected(true);
        songRepository.save(songItem);
    }

    @Override
    public SongDTO getSongDTO(int id) {
        Song songs = songRepository.findById(id).orElse(null);
        if (songs != null) {
            SongDTO songDTO = new SongDTO();

            songDTO.setId(songs.getId());
            songDTO.setName(songs.getName());
            songDTO.setAuthor(songs.getAuthor());
            songDTO.setDes(songs.getDes());
            return songDTO;
        }
        return null;
    }

    @Override
    public void updateSong(Song song) {
        Song oldSong = songRepository.findById(song.getId()).orElse(null);
        oldSong.setName(song.getName());
        oldSong.setAuthor(song.getAuthor());
        oldSong.setDes(song.getDes());
        songRepository.save(oldSong);
    }

}
