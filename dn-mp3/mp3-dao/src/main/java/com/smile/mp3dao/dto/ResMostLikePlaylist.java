package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.Playlist;

public class ResMostLikePlaylist {

     private Playlist playlist;
    private Long totalLike;

    public ResMostLikePlaylist() {
    }

    public ResMostLikePlaylist( Playlist playlist, Long totalLike) {

        this.playlist = playlist;
        this.totalLike = totalLike;
    }

    public ResMostLikePlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
