package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByDelectedIsFalse();
    List<Song> findAllByNameContainingAndDelectedIsFalse(String songName);
}
