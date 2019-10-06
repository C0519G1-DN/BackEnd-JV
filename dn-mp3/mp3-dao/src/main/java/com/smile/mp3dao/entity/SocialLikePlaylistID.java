package com.smile.mp3dao.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class SocialLikePlaylistID implements Serializable {


    private int playlists;

    private int users;




}
