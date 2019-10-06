package com.smile.mp3dao.dto;

import java.util.Date;

public class ResCommentPlaylist {



    private String username;

    private String comment;

    private Date createDate;

    public ResCommentPlaylist() {
    }

    public ResCommentPlaylist(String username, String comment, Date createDate) {
        this.username = username;
        this.comment = comment;
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
