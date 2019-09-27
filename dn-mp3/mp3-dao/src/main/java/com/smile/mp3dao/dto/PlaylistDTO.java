package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.Playlist;

import java.io.Serializable;
import java.util.Date;

public class PlaylistDTO implements Serializable {
    private int id;
    private String name;
    private String des;
    private String username_create;
//    private Date createDay;


    public PlaylistDTO() {
    }

    public PlaylistDTO(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.des = playlist.getDes();
        this.username_create = playlist.getUsername_create();
//        this.createDay = playlist.getCreateDay();
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
//
//    public Date getCreateDay() {
//        return createDay;
//    }
//
//    public void setCreateDay(Date createDay) {
//        this.createDay = createDay;
//    }
}
