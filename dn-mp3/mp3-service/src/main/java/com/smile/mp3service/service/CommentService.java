package com.smile.mp3service.service;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.CommentDTO;
import com.smile.mp3dao.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment(int idSinger);

    void saveComment(CommentDTO commentDTO);

    CommentDTO getCommentDTO(int id) throws ResourceNotFoundException;
}
