package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Song;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByDelectedIsFalse();

    List<Song> findAllByNameContainingAndDelectedIsFalse(String songName);


//    List<Song> findAllByDelectedIsFalseAndOrderByView_song(PageRequest pageRequest);

//    @Query(value = "select e.song, count(e.liked) from LikeSong e where (e.liked = 1) group by e.song")
//    List<Object[]> totalLikeSong(PageRequest pageRequest);

    @Query(value = "select e from Song e order by e.view_song desc")
    List<Song> topViewSong(PageRequest pageRequest);


}
