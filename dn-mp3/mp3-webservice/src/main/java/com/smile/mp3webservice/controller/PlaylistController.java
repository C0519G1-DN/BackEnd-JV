package com.smile.mp3webservice.controller;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;
import com.smile.mp3dao.repository.PlaylistRepository;
import com.smile.mp3service.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/playlists")

public class PlaylistController {
//    @Autowired
//    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistService playlistService;

    @GetMapping(value = {""})
    public List<PlaylistDTO> allPlaylistDTO() {
        List<PlaylistDTO> getAllPlaylistsDTO = playlistService.findAllByDelectedIsFalse();
        return getAllPlaylistsDTO;
    }

    @GetMapping(value = {"/getoneplaylist/{id}"})
    public ResponseEntity<PlaylistDTO> getOnePlaylistDTO(@PathVariable int id) throws ResourceNotFoundException {
        PlaylistDTO onePlaylistDTO = playlistService.getOnePlaylistDTO(id);
        return new ResponseEntity<PlaylistDTO>(onePlaylistDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/updateplaylist/{id}"})
    public ResponseEntity<PlaylistDTO> editPlaylist(@PathVariable int id, @RequestBody PlaylistDTO playlistDTO) {
//        playlistDTO.setId(id);
        playlistService.savePlaylist(playlistDTO);
//        return ResponseEntity.ok(playlist);
        return new ResponseEntity<PlaylistDTO>(playlistDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/createplaylist"})
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        playlistService.savePlaylist(playlistDTO);
        return ResponseEntity.ok(playlistDTO);
    }

    @DeleteMapping(value = {"/deleteplaylist/{id}"})
    public ResponseEntity<?> deletePlaylist(@PathVariable int id)
            throws ResourceNotFoundException {
        playlistService.deletePlaylist(id);
        return ResponseEntity.ok(id);
    }
}
