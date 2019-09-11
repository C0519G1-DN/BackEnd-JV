package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.SingerDTO;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3service.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerRepository singerRepository;

    @Override
    public List<Singer> getSingers() {
        return singerRepository.findAll();
    }

    @Override
    public void saveSinger(SingerDTO singerDTO) throws IOException {
        MultipartFile iSinger = singerDTO.getImg_singer();
        Singer singer = new Singer(singerDTO);
        singer.setLink_img_singer("assets\\"+iSinger.getOriginalFilename());
        Date date= new Date();
        singer.setCreateDate(date);
        singer.setDelected(false);
        singerRepository.save((singer));


    }

    @Override
    public Song getSinger(int theId) {
        return null;
    }
}