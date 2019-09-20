package com.smile.mp3webservice.controller;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.dto.SongDTO;
import com.smile.mp3dao.entity.Playlist;
import com.smile.mp3dao.entity.ReqAddSong;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.entity.User;
import com.smile.mp3dao.repository.PlaylistRepository;
import com.smile.mp3service.service.PlaylistService;
import com.smile.mp3service.service.SongService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/playlists")

public class PlaylistController {
//    @Autowired
//    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistService playlistService;
    @Autowired
    SongService songService;

    @GetMapping(value = {""})
    public List<Playlist> allPlaylistDTO() {
        List<Playlist> getAllPlaylistsDTO = playlistService.getPlaylists();
        return getAllPlaylistsDTO;
    }

    @GetMapping(value = {"/getoneplaylist/{id}"})
    public ResponseEntity<PlaylistDTO> getOnePlaylistDTO(@PathVariable int id) throws ResourceNotFoundException {
        PlaylistDTO onePlaylistDTO = playlistService.getOnePlaylistDTO(id);
        return new ResponseEntity<PlaylistDTO>(onePlaylistDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/songOfPlaylist"})
    public Set<Song> getSongsOfPlaylist(@RequestBody int idPlaylist) throws ResourceNotFoundException {
        Playlist playlist = playlistService.getOnePlaylist(idPlaylist);
        Set<Song> songs = playlist.getSongs();
//        List<SongDTO> songDTOS = new ArrayList<>();
//        for (Song song : playlist.getSongs()) {
//            SongDTO songDTO = new SongDTO();
//            songDTO = songService.getSongDTO(song.getId());
//            songDTOS.add(songDTO);
//        }
        return songs;
    }

    @PutMapping(value = {"/updateplaylist"})
    public ResponseEntity<PlaylistDTO> editPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        playlistService.savePlaylist(playlistDTO);
        return new ResponseEntity<PlaylistDTO>(playlistDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/createplaylist"})
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        playlistService.savePlaylist(playlistDTO);
        return new ResponseEntity<>(playlistDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/deleteplaylist"})
    public ResponseEntity<?> deletePlaylist(@RequestBody int id)
            throws ResourceNotFoundException {
        playlistService.deletePlaylist(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = {"/addsong"})
    public ResponseEntity<?> addSongtoPlaylist(@RequestBody ReqAddSong reqAddSong) {
        playlistService.savePlaylistWithSongs(reqAddSong.getIdPlaylist(), reqAddSong.getIdSong());
        return new ResponseEntity<ReqAddSong>(reqAddSong, HttpStatus.OK);
    }

    @PostMapping(value = {"/deletesonginplaylist"})
    public ResponseEntity<?> deletesonginplaylist (@RequestBody ReqAddSong reqAddSong){
        playlistService.deleteSongInPlaylist(reqAddSong.getIdPlaylist(),reqAddSong.getIdSong());
        return new ResponseEntity<ReqAddSong>(reqAddSong, HttpStatus.OK);
    }
}
