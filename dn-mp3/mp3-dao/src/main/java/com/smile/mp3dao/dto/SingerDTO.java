package com.smile.mp3dao.dto;

import org.springframework.web.multipart.MultipartFile;

public class SingerDTO {

    private String name;
    private String des;
    private MultipartFile img_singer;
    private int user_create;

    public SingerDTO() {
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

    public MultipartFile getImg_singer() {
        return img_singer;
    }

    public void setImg_singer(MultipartFile img_singer) {
        this.img_singer = img_singer;
    }

    public int getUser_create() {
        return user_create;
    }

    public void setUser_create(int user_create) {
        this.user_create = user_create;
    }
}
