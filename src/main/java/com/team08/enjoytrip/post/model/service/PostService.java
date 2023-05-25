package com.team08.enjoytrip.post.model.service;

import com.team08.enjoytrip.post.exception.ArticleNotFoundException;
import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.post.model.dto.PostCreateRequestDto;
import java.util.List;

public interface PostService {
    void addArticle(PostCreateRequestDto postCreateRequestDto) throws ArticleNotFoundException;

    void modifyArticle(PostDto postDto) throws ArticleNotFoundException;

    PostDto searchArticle(int articleId) throws ArticleNotFoundException;

    List<PostDto> searchArticles();
    List<PostDto> searchArticlesUser(int userId);
    List<PostDto> searchArticlesUserHistory(int userId);


    void delete(int articleId);

}
