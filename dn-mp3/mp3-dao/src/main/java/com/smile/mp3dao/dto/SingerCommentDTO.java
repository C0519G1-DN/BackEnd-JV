package com.smile.mp3dao.dto;

import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.User;

public class SingerCommentDTO {
    private String comment;
    private int idSinger;
    private int idUser;

    public SingerCommentDTO() {
    }

    public SingerCommentDTO(String comment, int idSinger, int idUser) {
        this.comment = comment;
        this.idSinger = idSinger;
        this.idUser = idUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdSinger() {
        return idSinger;
    }

    public void setIdSinger(int idSinger) {
        this.idSinger = idSinger;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
