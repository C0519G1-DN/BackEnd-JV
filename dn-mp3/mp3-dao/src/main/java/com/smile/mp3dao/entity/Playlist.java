package com.smile.mp3dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "playlist0")

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

}
