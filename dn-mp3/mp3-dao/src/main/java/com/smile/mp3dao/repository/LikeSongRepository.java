package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.LikeSong;
import com.smile.mp3dao.entity.Song;
import com.smile.mp3dao.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface LikeSongRepository extends JpaRepository<LikeSong, Integer> {

    LikeSong findByUserAndSong(User user, Song song);

    List<Song> findAllByLikedTrueOrderBySongId();
//    List<LikeSong> findAllBylAndLikedTrue

//    @Query
//    select song_id, count(liked) as 'amount_like' from mod4.like_song
//    group by song_id
//    limit 3;

//    @Query(value = "select e from LikeSong e")

//    @Query(value = "select e from LikeSong e group by e.song desc limit :limit", nativeQuery = true)
//    List<LikeSong> findAllByUserAndSong(@Param("limit") int limit);

    @Query(value = "select e from LikeSong e group by e.song")
    List<LikeSong> findAllByUserAndSong(PageRequest pageRequest);

    //    @Query(value = "select e.song, count(e.liked) from LikeSong e group by e.song")
//    HashMap<Integer, Integer> totalLikeSong();
    @Query(value = "select e.song, count(e.liked) from LikeSong e group by e.song")
    List<Object[]> totalLikeSong(PageRequest pageRequest);
}

