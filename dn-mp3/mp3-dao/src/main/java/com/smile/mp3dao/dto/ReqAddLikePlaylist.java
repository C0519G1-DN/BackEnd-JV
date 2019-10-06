package com.smile.mp3dao.dto;

public class ReqAddLikePlaylist {

    private int playlists_id;

    private int users_id;

    private Boolean liked;

    public int getPlaylists_id() {
        return playlists_id;
    }

    public void setPlaylists_id(int playlists_id) {
        this.playlists_id = playlists_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
