package com.smile.mp3webservice.controller;


import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Song;
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
public class SongController {

    @Autowired
    public SongService songService;

    @PostMapping(value={"/upsong"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addSong(@ModelAttribute SongDTO data) throws IOException {
        try{MultipartFile fSong = data.getFile_song();
            File convertFileSong = new File("E:\\IT\\IT-CodeGym\\4.Mod4\\MyRepository-C0519\\FrontEnd-Ng\\mp3-angular\\src\\assets\\"+fSong.getOriginalFilename());
            fSong.transferTo(convertFileSong);
            MultipartFile iSong = data.getImg_song();
            File convertImgSong = new File("E:\\IT\\IT-CodeGym\\4.Mod4\\MyRepository-C0519\\FrontEnd-Ng\\mp3-angular\\src\\assets\\"+iSong.getOriginalFilename());
            iSong.transferTo(convertImgSong);
            songService.saveSong(data);
            Song feedback = new Song(data);
            return new ResponseEntity<Song>(feedback, HttpStatus.OK);
        }
        catch (Exception e){
        return new ResponseEntity<>("Wrong", HttpStatus.BAD_REQUEST);
    }}

    @GetMapping( value = {"/getsongs"})
    private ResponseEntity<?> getSongs(){
        List<Song> songs = songService.getSongs();
        return ResponseEntity.ok(songs);
    }
}
