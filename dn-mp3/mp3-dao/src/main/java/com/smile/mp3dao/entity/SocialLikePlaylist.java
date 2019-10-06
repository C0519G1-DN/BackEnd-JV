package com.smile.mp3dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@IdClass(SocialLikePlaylistID.class)
public class SocialLikePlaylist implements Serializable {

    @Id
    @ManyToOne
    private Playlist playlists;

    @Id
    @ManyToOne
    private User users;

    @Column
    private Boolean liked;


    public SocialLikePlaylist() {
    }

    public Playlist getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist playlists) {
        this.playlists = playlists;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }


}
