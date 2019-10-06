package com.smile.mp3dao.repository;

import com.smile.mp3dao.dto.ResMostLikePlaylist;
import com.smile.mp3dao.entity.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialLikePlaylistRepository extends JpaRepository<SocialLikePlaylist, Integer> {

    Long countByLikedIsTrueAndPlaylists_Id(int idPlaylist);

    SocialLikePlaylist findSocialLikePlaylistsByUsers_IdAndAndPlaylists_Id(int idUser, int idPlaylist);

    String a = "SELECT NEW com.smile.mp3dao.dto.ResMostLikePlaylist(e.playlists, COUNT(e.liked))" +
        "FROM SocialLikePlaylist e where liked  = true " +
        "GROUP BY e.playlists ORDER BY COUNT(e.liked) DESC";

    @Query(a)
    List<ResMostLikePlaylist> gogogo(Pageable pageable);



}
