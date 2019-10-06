package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.SocialCommentPlaylist;

public class SocialCommentPlaylistDTO {

    private int playlists_id;

    private int users_id;

    private String comment;

    public SocialCommentPlaylistDTO( ) {
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
