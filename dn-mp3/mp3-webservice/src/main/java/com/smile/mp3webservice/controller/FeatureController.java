package com.smile.mp3webservice.controller;

import com.smile.mp3dao.entity.Playlist;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3service.service.PlaylistService;
import com.smile.mp3service.service.SingerService;
import com.smile.mp3service.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeatureController {
    @Autowired
    public SingerService singerService;

    @Autowired
    public SongService songService;

    @Autowired
    public PlaylistService playlistService;

    @PostMapping("/searchName")
    public ResponseEntity<?> searchAllSongSingerPlaylistByName(@RequestBody String name) {
        List<Singer> listSingerName = singerService.getName(name);
        List<Song> listSongName = songService.searchSongName(name);
        List<Playlist> listPlaylistName = playlistService.getAllPlaylistByName(name);
        List listName = new ArrayList<>();
        listName.add(listSingerName);
        listName.add(listSongName);
        listName.add(listPlaylistName);

        return ResponseEntity.ok(listName);
    }
}
