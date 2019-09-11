package com.smile.mp3dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist02")

public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String des;
    private String username_create;
    private Date createDay;
    private Boolean delected;

    @ManyToMany
    @JoinTable(
            name="playlist_song",
            joinColumns=@JoinColumn(name="playlist_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="song_id", referencedColumnName="id"))
    private Set<Song> songs = new HashSet<Song>();

    public Playlist() {
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

    public String getUsername_create() {
        return username_create;
    }

    public void setUsername_create(String username_create) {
        this.username_create = username_create;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

        public Boolean getDelected() {
        return delected;
    }

    public void setDelected(Boolean delected) {
        this.delected = delected;
    }



    public Set<Song> getSongs() {
        return songs;
    }
    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
