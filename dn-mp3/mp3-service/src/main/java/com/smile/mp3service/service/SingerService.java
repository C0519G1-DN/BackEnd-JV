package com.smile.mp3service.service;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.SingerDTO;
import com.smile.mp3dao.entity.Singer;

import java.io.IOException;
import java.util.List;

public interface SingerService {


    List<Singer> getSingers();

    void saveSinger(SingerDTO singerDTO) throws IOException;

//    Song getSinger(int id);

    Singer getSinger(int id) throws ResourceNotFoundException;

    Singer deleteSinger(int theId);

}
