package com.smile.mp3service.service;

import com.smile.mp3dao.dto.SingerDTO;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.Song;

import java.io.IOException;
import java.util.List;

public interface SingerService {

    List<Singer> getSingers();

    void saveSinger(SingerDTO singerDTO) throws IOException;

    Song getSinger(int id);
}