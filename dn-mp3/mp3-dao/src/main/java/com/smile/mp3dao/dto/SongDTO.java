package com.smile.mp3dao.dto;

import org.springframework.web.multipart.MultipartFile;

public class SongDTO {

        private String name;
        private String des;
        private MultipartFile file_song;
        private String author;
        private MultipartFile img_song;
        private int user_create;

    public SongDTO() {
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

    public MultipartFile getFile_song() {
        return file_song;
    }

    public void setFile_song(MultipartFile file_song) {
        this.file_song = file_song;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getImg_song() {
        return img_song;
    }

    public void setImg_song(MultipartFile img_song) {
        this.img_song = img_song;
    }

    public int getUser_create() {
        return user_create;
    }

    public void setUser_create(int user_create) {
        this.user_create = user_create;
    }
}
