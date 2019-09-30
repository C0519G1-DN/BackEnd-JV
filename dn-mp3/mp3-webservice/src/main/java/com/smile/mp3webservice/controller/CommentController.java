package com.smile.mp3webservice.controller;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.CommentDTO;
import com.smile.mp3dao.entity.Comment;
import com.smile.mp3dao.repository.CommentRepository;
import com.smile.mp3service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/getAll/{id}")
    public ResponseEntity<?> getAllComment(@PathVariable int id){
//        List<Comment> comments = commentService.getAllComment(id);
        List<Comment> comments = commentRepository.findCommentBySong_Id(id);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/saveCmt")
    public ResponseEntity<?> saveComment(@RequestBody CommentDTO commentDTO) {
        commentService.saveComment(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("/getCmt/{id}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable("id") int id) throws ResourceNotFoundException {
        CommentDTO commentDTO = commentService.getCommentDTO(id);
        return new ResponseEntity<CommentDTO>(commentDTO, HttpStatus.OK);
    }
}
