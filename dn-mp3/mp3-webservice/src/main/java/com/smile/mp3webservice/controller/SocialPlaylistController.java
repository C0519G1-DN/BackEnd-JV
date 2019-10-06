package com.smile.mp3webservice.controller;

import com.smile.mp3common.exception.ResourceNotFoundException;
import com.smile.mp3dao.dto.*;
import com.smile.mp3dao.repository.SocialLikePlaylistRepository;
import com.smile.mp3service.service.SocialCommentPlaylistService;
import com.smile.mp3service.service.SocialLikePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocialPlaylistController {

    @Autowired
    public SocialLikePlaylistService socialLikePlaylistService;

    @Autowired
    public SocialLikePlaylistRepository socialLikePlaylistRepository;

    @Autowired
    public SocialCommentPlaylistService socialCommentPlaylistService;

    @GetMapping(value = {"/getLikesPlaylist/{idUser}/{idPlaylist}"})
    public ResponseEntity<?> okok(@PathVariable int idUser,@PathVariable int idPlaylist) throws ResourceNotFoundException {
        Long totalLike = socialLikePlaylistService.getTotallike(idPlaylist);
        Boolean isLike = socialLikePlaylistService.getDoLikeByUserWithPlaylist(idUser,idPlaylist);
        return new ResponseEntity<ResLikePlaylist>( new ResLikePlaylist(totalLike,isLike), HttpStatus.OK);
    }

    @PostMapping(value = "/postLikePlaylist")
    public  ResponseEntity<?> postLike (@RequestBody ReqAddLikePlaylist reqAddLikePlaylist){
        socialLikePlaylistService.saveSLP(reqAddLikePlaylist);
        return new ResponseEntity<ReqAddLikePlaylist>( reqAddLikePlaylist, HttpStatus.OK);
    }

    @GetMapping(value = {"/getToMostLikePlaylist"})
    public ResponseEntity<?> getToMostLikePlaylist() throws ResourceNotFoundException {
        List<ResMostLikePlaylist> list = socialLikePlaylistRepository.gogogo(new PageRequest(0,2));
        return new ResponseEntity<List<ResMostLikePlaylist>>( list, HttpStatus.OK);
    }

    @PostMapping(value = "/postCommentPlaylist")
    public  ResponseEntity<?> postComment (@RequestBody SocialCommentPlaylistDTO req){
        socialCommentPlaylistService.saveSCP(req);
        return new ResponseEntity<SocialCommentPlaylistDTO>( req, HttpStatus.OK);
    }

    @GetMapping(value = {"/getCommentsPlaylist/{idPlaylist}"})
    public ResponseEntity<?> okoko(@PathVariable int idPlaylist) throws ResourceNotFoundException {
        List<ResCommentPlaylist> res = socialCommentPlaylistService.findAll(idPlaylist);
        return new ResponseEntity<List<ResCommentPlaylist>>( res, HttpStatus.OK);
    }

}
