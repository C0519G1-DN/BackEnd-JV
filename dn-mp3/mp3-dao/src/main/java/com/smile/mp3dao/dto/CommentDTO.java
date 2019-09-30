package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.Comment;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CommentDTO {
    private int id_user;
    private int id_song;
    private String content;
    private Date date;

    public CommentDTO(int id_user, int id_song, String content) {
        this.id_user = id_user;
        this.id_song = id_song;
        this.content = content;
    }

    public int getId_song() {
        return id_song;
    }

    public void setId_song(int id_song) {
        this.id_song = id_song;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
