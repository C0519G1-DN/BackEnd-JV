package com.smile.mp3dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "singer_comment")
public class SingerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "singer_id", nullable = false)
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public SingerComment() {
    }

    public SingerComment(int id, String comment, Singer singer, User user) {
        this.id = id;
        this.comment = comment;
        this.singer = singer;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
