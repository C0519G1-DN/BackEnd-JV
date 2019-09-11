package com.smile.mp3dao.entity;

public class ReqAddSong {
    private int idPlaylist;
    private int idSong;

    public ReqAddSong() {
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }
}
