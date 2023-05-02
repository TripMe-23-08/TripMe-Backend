package com.team08.enjoytrip.post.model.service;

import com.team08.enjoytrip.post.exception.ArticleNotFoundException;
import com.team08.enjoytrip.post.model.dto.PostDto;
import java.util.List;

public interface PostService {
    void addArticle(PostDto postDto) throws ArticleNotFoundException;

    void modifyArticle(PostDto postDto) throws ArticleNotFoundException;

    PostDto searchArticle(int articleId) throws ArticleNotFoundException;

    List<PostDto> searchArticles();

    void delete(int articleId);
}
