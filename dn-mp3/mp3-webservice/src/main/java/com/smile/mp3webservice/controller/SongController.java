package com.smile.mp3webservice.controller;


import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.LikeSongDTO;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.ReqAddSinger;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.repository.LikeViewSongRepository;
import com.smile.mp3service.service.LikeViewSongService;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SongController {

    String AAA = "D:\\IT\\IT-CodeGym\\checkMod4\\FrontEnd-v2\\mp3-angular\\src\\assets\\";

    @Autowired
    public SongService songService;

    @Autowired
    LikeViewSongService likeViewSongService;

    @Autowired
    LikeViewSongRepository likeViewSongRepository;

    @PostMapping(value = {"/upsong"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addSong(@ModelAttribute SongDTO data) throws IOException {


        try {
            MultipartFile fSong = data.getFile_song();
            File convertFileSong = new File(AAA + fSong.getOriginalFilename());
            fSong.transferTo(convertFileSong);
            MultipartFile iSong = data.getImg_song();
            File convertImgSong = new File(AAA + iSong.getOriginalFilename());


            iSong.transferTo(convertImgSong);
            songService.saveSong(data);
            Song feedback = new Song(data);
            return new ResponseEntity<Song>(feedback, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = {"/getsongs"})
    private ResponseEntity<?> getSongs() {
        List<Song> songs = songService.getSongs();
        return ResponseEntity.ok(songs);
    }



    @GetMapping(value = {"/getIdSong/{id}"})
    public ResponseEntity<Song> getSongDTO(@PathVariable int id) throws ResourceNotFoundException {
        Song oneSong = songService.getSong(id);
        return new ResponseEntity<Song>(oneSong, HttpStatus.OK);
    }

    @PutMapping(value = {"/updateSong"})
    public ResponseEntity<?> editSong(@RequestBody Song song) {
        songService.updateSong(song);
        return new ResponseEntity<Song>(song, HttpStatus.OK);
    }


    @PostMapping(value = "/addSingerToSong")
    public ResponseEntity<?> addSingerToSong(@RequestBody ReqAddSinger reqAddSinger) {
        songService.saveSongWithSinger(reqAddSinger.getIdSong(), reqAddSinger.getIdSinger());
        return ResponseEntity.ok("ok");
    }

    @PutMapping(value = "/likesong")
    public ResponseEntity<?> likeSong(@RequestBody LikeSongDTO likeSongDTO) {
        System.out.println(likeSongDTO.getUsername());
        System.out.println(likeSongDTO.getIdSong());
        System.out.println(likeSongDTO.isLike());
        System.out.println("----------");
        likeViewSongService.likeSong(likeSongDTO.getUsername(), likeSongDTO.getIdSong(), likeSongDTO.isLike());
        return new ResponseEntity<LikeSongDTO>(likeSongDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/getLike")
    public ResponseEntity<?> getLike(@RequestBody LikeSongDTO likeSongDTO) {
        Boolean isLike = likeViewSongService.getLike(likeSongDTO.getUsername(), likeSongDTO.getIdSong());
        System.out.println(isLike);
        return ResponseEntity.ok(isLike);
    }

//    @GetMapping(value = "/getTopLike")
//    public ResponseEntity<?> getTopLike(){
//        List<LikeSong> topLikeSongs = likeSongService.getTopLike();
////        List<Song> topLikeSongs = likeSongRepository.findAllByLikedTrueOrderBySongId();
//        return ResponseEntity.ok(topLikeSongs);
//    }

    @GetMapping(value = "/getTopLike")
    public ResponseEntity<?> getTotalLikeOfSong(){
        List<Object[]> getTotalLikeOfSong = likeViewSongService.getTotalLikeSong();
        return ResponseEntity.ok(getTotalLikeOfSong);
    }


    @PostMapping("/searchSongName")
    public ResponseEntity<?> getSongName(@RequestBody String nameSong) {
        List<Song> list = songService.searchSongName(nameSong);
        return ResponseEntity.ok(list);
    }
    @PostMapping(value = "/getViewSong")
    public ResponseEntity<?> getViewSong(@RequestBody int idSong){
        int viewSong = likeViewSongService.viewSong(idSong);
        return ResponseEntity.ok(viewSong);
    }

    @GetMapping(value = "/getTopViewSong")
    public ResponseEntity<?> getTopViewSong(){
        List<Song> topViewSong = songService.getTopViewSong();
        return ResponseEntity.ok(topViewSong);
    }

    @PostMapping(value = "/getLikeOfSong")
    public ResponseEntity<?> getLikeOfSong(@RequestBody int idSong){
        int likesSong = likeViewSongService.getLikeOfSong(idSong);
        return ResponseEntity.ok(likesSong);

    }
}
