package com.team08.enjoytrip.post.model.service;

public interface LikePostService {
    void addLikeToArticle(int postId, int userId);

    void deleteArticleLike(int articleId, int userId);
}
