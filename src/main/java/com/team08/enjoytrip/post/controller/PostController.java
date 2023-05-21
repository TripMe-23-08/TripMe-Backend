package com.team08.enjoytrip.post.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.post.model.service.PostService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/articles")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<ResponseDto> addArticle(@RequestBody PostDto postDto) {
        log.debug("[POST] /articles : " + postDto);
        postService.addArticle(postDto);
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
    

}
