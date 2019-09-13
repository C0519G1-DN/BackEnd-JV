package com.smile.mp3webservice.controller;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.SingerDTO;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3service.service.SingerService;
import com.smile.mp3service.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class SingerController {

    @Autowired
    public SingerService singerService;

    @PostMapping(value={"/upsinger"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addSong(@ModelAttribute SingerDTO data) throws IOException {
        try{
            MultipartFile iSinger = data.getImg_singer();

            File convertImgSinger = new File("E:\\IT\\IT-CodeGym\\4.Mod4\\MyRepository-C0519\\FrontEnd-Ng\\mp3-angular\\src\\assets\\"+iSinger.getOriginalFilename());

            iSinger.transferTo(convertImgSinger);
            singerService.saveSinger(data);
            Singer feedback = new Singer(data);
            return new ResponseEntity<Singer>(feedback, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Wrong", HttpStatus.BAD_REQUEST);
        }}
    @GetMapping( value = {"/getsingers"})
    private ResponseEntity<?> getSingers(){
        List<Singer> singers= singerService.getSingers();
        return ResponseEntity.ok(singers);
    }

    @GetMapping(value = "/singer/{id}")
    public ResponseEntity<Singer> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        Singer singer =singerService.getSinger(id);
        return ResponseEntity.ok(singer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        singerService.deleteSinger(id);
        return ResponseEntity.ok(id);
    }

}
