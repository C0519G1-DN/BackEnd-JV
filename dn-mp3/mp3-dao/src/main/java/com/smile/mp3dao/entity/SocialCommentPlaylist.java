package com.smile.mp3dao.entity;

import com.smile.mp3dao.dto.SocialCommentPlaylistDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class SocialCommentPlaylist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Playlist playlists;


    @ManyToOne
    private User users;

    @Column
    private String comment;

    @Column(name = "date_create")
    private Date createDate;

    //    private boolean delected;

    public SocialCommentPlaylist() {
    }





    public SocialCommentPlaylist(Playlist playlists, User users, String comment, Date createDate) {
        this.playlists = playlists;
        this.users = users;
        this.comment = comment;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
