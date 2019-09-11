package com.smile.mp3service.service;

import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Song;

import java.io.IOException;
import java.util.List;

public interface SongService {

        List<Song> getSongs();

    void saveSong(SongDTO songDTO) throws IOException;

    Song getSong(int id);

    void deleteSong(int id);
}
