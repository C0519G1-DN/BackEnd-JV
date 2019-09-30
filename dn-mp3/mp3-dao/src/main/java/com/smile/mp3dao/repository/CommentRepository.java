package com.smile.mp3dao.repository;

import com.smile.mp3dao.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentBySong_Id(int id);
}
