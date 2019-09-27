package com.smile.mp3dao.entity;
import com.smile.mp3dao.dto.SongDTO;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "song0")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private int id;

    @Column(name = "name_song")
        private String name;

    @Column(name = "des_song")
        private String des;
        private String link_song;
        private String author;

    @Column(name = "img_song")
        private String link_img_song;

    @Column(name = "date_create")
        private Date createDate;

        private int view_song = 0;

        private boolean delected;

        private int user_create;

    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists =new ArrayList<Playlist>();

    public Song() {
    }

    @ManyToMany
    @JoinTable(
            name="song_singer",
            joinColumns=@JoinColumn(name="song_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="singer_id", referencedColumnName="id"))
    private Set<Singer> singers = new HashSet<Singer>();



    public Song(SongDTO original) {
        this.name = original.getName();
        this.des = original.getDes();
        this.author = original.getAuthor();
        this.user_create = original.getUser_create();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink_song() {
        return link_song;
    }

    public void setLink_song(String link_song) {
        this.link_song = link_song;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink_img_song() {
        return link_img_song;
    }

    public void setLink_img_song(String link_img_song) {
        this.link_img_song = link_img_song;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getView_song() {
        return view_song;
    }

    public void setView_song(int view_song) {
        this.view_song = view_song;
    }

    public boolean getDelected() {
        return delected;
    }

    public void setDelected(boolean delected) {
        this.delected = delected;
    }

    public int getUser_create() {
        return user_create;
    }

    public void setUser_create(int user_create) {
        this.user_create = user_create;
    }

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }
}

