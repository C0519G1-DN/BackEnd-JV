package com.smile.mp3dao.dto;

public class ResLikePlaylist {

    private Long totalLike;

    private Boolean isLiked;

    public ResLikePlaylist() {
    }

    public ResLikePlaylist(Long totalLike, Boolean isLiked) {
        this.totalLike = totalLike;
        this.isLiked = isLiked;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }
}
