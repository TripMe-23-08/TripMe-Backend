package com.team08.enjoytrip.post.controller;

import com.team08.enjoytrip.auth.JwtUtil;
import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.post.model.dto.PostRequestDto;
import com.team08.enjoytrip.post.model.service.HistoryPostService;
import com.team08.enjoytrip.post.model.service.PostService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/articles")
public class PostController {
    private PostService postService;

    @Autowired
    private JwtUtil jwtUtil;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<ResponseDto> addArticle(@RequestHeader("Authorization") String token, @RequestBody PostRequestDto postRequestDto) {
        log.debug("[POST] /articles : " + postRequestDto);
        Map<String, Object>  claims = jwtUtil.getClaims(token);
        //postRequestDto.setUserId((Integer) claims.get("userId"));
        postRequestDto.setUserId(3);
        postService.addArticle(postRequestDto);
        return new ResponseEntity<>(new ResponseDto("글 추가", null), HttpStatus.OK);
    }
    @PutMapping("/{articleId}")
    public ResponseEntity<ResponseDto> modifyArticle(@PathVariable int articleId, @RequestBody PostDto postDto) {
        log.debug("[PUT] /articles/{articleId} : " + articleId);
        postService.modifyArticle(postDto);
        return new ResponseEntity<>(new ResponseDto("글 수정", null), HttpStatus.OK);
    }
    @GetMapping("/{articleId}")
    public ResponseEntity<ResponseDto> searchArticle(@PathVariable int articleId) {
        log.debug("[GET] /articles/{articleId} : " + articleId);

        PostDto articleDto = postService.searchArticle(articleId);
        log.debug("PostDto "+articleDto);
        return new ResponseEntity<>(new ResponseDto("특정 글 조회", articleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<ResponseDto> deleteArticle(@PathVariable int articleId) {
        log.debug("[DELETE] /articles/{articleId} : " + articleId);

        postService.delete(articleId);
        return new ResponseEntity<>(new ResponseDto("특정 글 삭제", null), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ResponseDto> searchArticles() {
        log.debug("[GET] /articles : ");
        //TODO :글 목록 조회 조건 추가
        List<PostDto> articleDto = postService.searchArticles();
        log.debug("List<PostDto>  "+articleDto);
        return new ResponseEntity<>(new ResponseDto("글 목록 조회", articleDto), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseDto> searchArticlesUser(@PathVariable int userId) {
        log.debug("[GET] /articles/user/" + userId);
        //TODO :글 목록 조회 조건 추가
        List<PostDto> articleDto = postService.searchArticlesUser(userId);
        log.debug("List<PostDto>  "+articleDto);
        return new ResponseEntity<>(new ResponseDto("유저 글 목록 조회", articleDto), HttpStatus.OK);
    }

    @GetMapping("/user-history/{userId}")
    public ResponseEntity<ResponseDto> searchArticlesUserHistory(@PathVariable int userId) {
        log.debug("[GET] /articles/user-history/" + userId);
        //TODO :글 목록 조회 조건 추가
        List<PostDto> articleDto = postService.searchArticlesUserHistory(userId);
        log.debug("List<PostDto>  "+articleDto);
        return new ResponseEntity<>(new ResponseDto("유저 히스토리 글 목록 조회", articleDto), HttpStatus.OK);
    }

}
