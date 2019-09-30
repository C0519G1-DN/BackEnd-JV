package com.smile.mp3service.service.impl;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.CommentDTO;
import com.smile.mp3dao.entity.Comment;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.repository.CommentRepository;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3dao.repository.SongRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired private SingerRepository singerRepository;

    @Override
    public List<Comment> getAllComment(int idSinger) {
        List<Comment> commentsAll = commentRepository.findAll();
        List<Comment> comments = new ArrayList<>();
        for (Comment c:commentsAll
             ) {
            if(c.getSong().getId()== idSinger){
                comments.add(c);
            };
        }
        return comments;

    }

    @Override
    public void saveComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        Date date = new Date();

        comment.setUser(userRepository.findById(commentDTO.getId_user()).orElse(null));
        comment.setSong(songRepository.findById(commentDTO.getId_song()).orElse(null));
        comment.setContent(commentDTO.getContent());
        comment.setDate(date);
        commentRepository.save(comment);
    }

    @Override
    public CommentDTO getCommentDTO(int id) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("id not found!"));
        CommentDTO commentDTO = new CommentDTO(comment.getUser().getId(),comment.getSong().getId(),comment.getContent());
        return commentDTO;
    }
}
