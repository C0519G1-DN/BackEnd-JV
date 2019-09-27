package com.smile.mp3service.service;

import com.smile.mp3dao.dto.SingerCommentDTO;
import com.smile.mp3dao.entity.SingerComment;

import java.util.List;

public interface SingerCommentService {
    List<SingerComment> getComment(int idSinger);
    public void postComment(SingerCommentDTO singerCommentDTO);
}
