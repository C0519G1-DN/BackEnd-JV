package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Playlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    List<Playlist> findAllByDelectedIsFalse();

    String b = "SELECT e FROM Playlist e ORDER BY e.view DESC";

    @Query(b)
    List<Playlist> gogogo2(Pageable pageable);

}
