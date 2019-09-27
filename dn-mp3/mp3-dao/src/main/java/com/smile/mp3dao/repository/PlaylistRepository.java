package com.smile.mp3dao.repository;

import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> findAllByDelectedIsFalse();

    Playlist findByIdAndDelectedIsFalse(int id);
    List<Playlist> findAllByNameContainingAndDelectedIsFalse(String namePlaylist);
}
