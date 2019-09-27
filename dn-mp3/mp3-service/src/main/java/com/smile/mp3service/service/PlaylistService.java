package com.smile.mp3service.service;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    void savePlaylist(PlaylistDTO playlistDTO);

    void savePlaylistWithSongs(int idPlaylist, int idSong);

    void deleteSongInPlaylist(int idPlaylist, int idSong);

    List<Playlist> getPlaylists();

    Playlist getOnePlaylist(int id) throws ResourceNotFoundException;

    PlaylistDTO getOnePlaylistDTO(int id) throws ResourceNotFoundException;

    void deletePlaylist(int id) throws ResourceNotFoundException;

    List<Playlist> getAllPlaylistByName(String namePlaylist);
}
