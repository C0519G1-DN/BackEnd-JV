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
public interface LikeViewSongRepository extends JpaRepository<LikeSong, Integer> {

    LikeSong findByUserAndSong(User user, Song song);

    List<Song> findAllByLikedTrueOrderBySongId();

//    @Query
//    select song_id, count(liked) as 'amount_like' from mod4.like_song
//    group by song_id
//    limit 3;

    @Query(value = "select e.song, count(e.liked) from LikeSong e where (e.liked = 1) group by e.song order by count(e.liked) desc ")
    List<Object[]> totalLikeSong(PageRequest pageRequest);

    @Query(value = "select count(e.liked) from LikeSong e where (e.song = :song1 and e.liked = 1)")
    int getLikeOfSong(@Param("song1") Song song1);

//   cach2: int countByLikedIsTrueAndSong_Id(int idSong);
}

