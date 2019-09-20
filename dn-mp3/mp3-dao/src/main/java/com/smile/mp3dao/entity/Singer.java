package com.smile.mp3dao.entity;


import com.smile.mp3dao.dto.SingerDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "singer0")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_singer")
    private String name;

    @Column(name = "des_singer")
    private String des;

    @Column(name = "img_singer")
    private String link_img_singer;

    @Column(name = "date_create")
    private Date createDate;

    private int user_create;

    private boolean delected;

    @ManyToMany(mappedBy = "singers")
    private List<Song> songs =new ArrayList<Song>();



    public Singer() {
    }

    public Singer(int id, String name, String des, String link_img_singer, Date createDate, int user_create, boolean delected, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.link_img_singer = link_img_singer;
        this.createDate = createDate;
        this.user_create = user_create;
        this.delected = delected;
        this.songs = songs;
    }

    public Singer(SingerDTO original) {
        this.name = original.getName();
        this.des = original.getDes();
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

    public String getLink_img_singer() {
        return link_img_singer;
    }

    public void setLink_img_singer(String link_img_singer) {
        this.link_img_singer = link_img_singer;
    }

    public int getUser_create() {
        return user_create;
    }

    public void setUser_create(int user_create) {
        this.user_create = user_create;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getDelected() {
        return delected;
    }

    public void setDelected(boolean delected) {
        this.delected = delected;
    }

//    public List<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(List<Song> songs) {
//        this.songs = songs;
//    }



}
