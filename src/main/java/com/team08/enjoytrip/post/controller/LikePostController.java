package com.team08.enjoytrip.post.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.post.model.service.LikePostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@Slf4j
@RestController
public class LikePostController {
    private LikePostService likePostService;

    public LikePostController(LikePostService likePostService) {
        this.likePostService = likePostService;
    }

    @PostMapping("/articles/{articleId}/like")
    public ResponseEntity<ResponseDto> likePost(@PathVariable int articleId, @RequestHeader("Authorization") int userId) {
        log.debug("[POST] /articles/{articleId}/like" + articleId + " " + userId);
        //int userId = JWTtoken.getUserId(token);
        likePostService.addLikeToArticle(articleId, userId);

        return new ResponseEntity<>(new ResponseDto("글 좋아요 표시 성공", null), HttpStatus.OK);
    }

    @DeleteMapping("/articles/{articleId}/like")
    public ResponseEntity<ResponseDto> deleteLikePost(@PathVariable int articleId, @RequestHeader("Authorization") int userId) {
        log.debug("[POST] /articles/{articleId}/like" + articleId + " userId:" + userId);
        likePostService.deleteArticleLike(articleId, userId);

        return new ResponseEntity<>(new ResponseDto("글 좋아요 표시 제거 성공", null), HttpStatus.OK);
    }
}
