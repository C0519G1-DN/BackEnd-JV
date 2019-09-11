package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3service.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;


    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public void saveSong(SongDTO songDTO) throws IOException {
        MultipartFile fSong = songDTO.getFile_song();
        MultipartFile iSong = songDTO.getImg_song();
        Date date= new Date();
        Song theSong = new Song(songDTO);
        theSong.setLink_song("assets\\"+fSong.getOriginalFilename());
        theSong.setLink_img_song("assets\\"+iSong.getOriginalFilename());
        theSong.setView_song(0);
        theSong.setCreateDate(date);
        theSong.setDelected(false);

        songRepository.save(theSong);

    }

    @Override
    public Song getSong(int id) {
        return null;
    }

    @Override
    public void deleteSong(int id) {

    }
}
