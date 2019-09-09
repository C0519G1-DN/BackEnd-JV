package com.smile.mp3dao.repository;

import com.smile.mp3dao.dto.PlaylistDTO;
import com.smile.mp3dao.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<PlaylistDTO> findAllByDelectedIsFalse();
}