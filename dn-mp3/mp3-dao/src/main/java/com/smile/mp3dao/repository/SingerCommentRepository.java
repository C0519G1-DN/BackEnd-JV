package com.smile.mp3dao.repository;

import com.smile.mp3dao.dto.SingerCommentDTO;
import com.smile.mp3dao.entity.Singer;
import com.smile.mp3dao.entity.SingerComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerCommentRepository extends JpaRepository<SingerComment ,Integer> {
    List<SingerComment> findAllBySinger(Singer singer);

}
