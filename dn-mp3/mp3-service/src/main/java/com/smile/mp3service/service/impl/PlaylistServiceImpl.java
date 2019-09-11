package com.smile.mp3service.service.impl;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.constant.AppConstant;
import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.repository.PlaylistRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3service.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    SongRepository songRepository;

    @Override
    public void savePlaylist(PlaylistDTO playlistDTO) {
        Date date = new Date();
        Playlist playlist = new Playlist();
        playlist.setId(playlistDTO.getId());
        playlist.setName(playlistDTO.getName());
        playlist.setDes(playlistDTO.getDes());
        playlist.setUsername_create(playlistDTO.getUsername_create());
        playlist.setCreateDay(date);
        playlist.setDelected(false);

        playlistRepository.save(playlist);
    }

    @Override
    public void savePlaylistWithSongs(int idPlaylist, int idSong) {
        Playlist thePlaylist = playlistRepository.findById(idPlaylist).orElse(null);
        Song theSong = songRepository.findById(idSong).orElse(null);
        Set<Song> set = thePlaylist.getSongs();
        set.add(theSong);
        thePlaylist.setSongs(set);
        playlistRepository.save(thePlaylist);
    }

//    @Override
//    public List<PlaylistDTO> findAllByDelectedIsFalse() {
//        return playlistRepository.findAllByDelectedIsFalse();
//    }
@Override
public List<Playlist> getPlaylists(){
        return playlistRepository.findAll();
}


    @Override
    public Playlist getOnePlaylist(int id) throws ResourceNotFoundException {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlists is not found this id: " + id));
    }

    @Override
    public PlaylistDTO getOnePlaylistDTO(int id) throws ResourceNotFoundException {
        Playlist getOnePlaylist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlists not found this id: " + id));
        PlaylistDTO getOnePlaylistDTO = new PlaylistDTO(getOnePlaylist);
        return getOnePlaylistDTO;
    }

    @Override
    public void deletePlaylist(int id) throws ResourceNotFoundException {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlists not found this id: " + id));
        playlist.setDelected(true);
        playlistRepository.save(playlist);
    }
}
