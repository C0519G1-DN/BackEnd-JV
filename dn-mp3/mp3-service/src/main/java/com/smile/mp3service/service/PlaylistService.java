package com.smile.mp3service.service;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    void savePlaylist(PlaylistDTO playlistDTO);

//    List<Playlist> findAllByDelectedIsFalse();
    List<PlaylistDTO> findAllByDelectedIsFalse();

    Playlist getOnePlaylist(int id) throws ResourceNotFoundException;
    PlaylistDTO getOnePlaylistDTO(int id) throws ResourceNotFoundException;

    void deletePlaylist(int id) throws ResourceNotFoundException;
}
