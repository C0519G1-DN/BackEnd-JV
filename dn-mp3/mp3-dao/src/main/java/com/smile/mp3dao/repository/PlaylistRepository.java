package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
