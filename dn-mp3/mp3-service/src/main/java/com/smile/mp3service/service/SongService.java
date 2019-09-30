package com.smile.mp3service.service;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Song;

import java.io.IOException;
import java.util.List;

public interface SongService {

    List<Song> getSongs();

    void saveSong(SongDTO songDTO);

    void saveSongWithSinger(int idSong, int idSinger);

    Song getSong(int id);

    void deleteSong(int id) throws ResourceNotFoundException;

    SongDTO getSongDTO(int id);

    void updateSong(Song song);


    List<Song> searchSongName(String songName);

    List<Song> getTopViewSong();

}
