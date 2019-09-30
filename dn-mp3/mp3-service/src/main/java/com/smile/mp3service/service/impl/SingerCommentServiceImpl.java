package com.smile.mp3service.service.impl;

import com.smile.mp3dao.dto.SingerCommentDTO;
import com.smile.mp3dao.entity.SingerComment;
import com.smile.mp3dao.repository.SingerCommentRepository;
import com.smile.mp3dao.repository.SingerRepository;
import com.smile.mp3dao.repository.UserRepository;
import com.smile.mp3service.service.SingerCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerCommentServiceImpl implements SingerCommentService {
    @Autowired
    SingerCommentRepository singerCommentRepository;
    @Autowired
    SingerRepository singerRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<SingerComment> getComment(int idSinger) {
        return singerCommentRepository.findAllBySinger(singerRepository.findByDelectedIsFalseAndId(idSinger));
    }

    @Override
    public void postComment(SingerCommentDTO singerCommentDTO) {
        SingerComment singerComment = new SingerComment();
        singerComment.setSinger(singerRepository.findByDelectedIsFalseAndId(singerCommentDTO.getIdSinger()));
        singerComment.setComment(singerCommentDTO.getComment());
        singerComment.setUser(userRepository.findAllByDelectedIsFalseAndId(singerCommentDTO.getIdUser()));
        singerCommentRepository.save(singerComment);
    }
}
