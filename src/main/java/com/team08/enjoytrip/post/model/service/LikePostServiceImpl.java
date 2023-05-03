package com.team08.enjoytrip.post.model.service;

import com.team08.enjoytrip.post.model.repository.LikePostRepository;
import org.springframework.stereotype.Service;

@Service
public class LikePostServiceImpl implements LikePostService{
    private LikePostRepository likePostRepository;

    public LikePostServiceImpl(LikePostRepository likePostRepository) {
        this.likePostRepository = likePostRepository;
    }

    @Override
    public void addLikeToArticle(int postId, int userId) {
        likePostRepository.save(postId, userId);
    }

    @Override
    public void deleteArticleLike(int articleId, int likeId) {
        likePostRepository.deleteByArticleIdAndUserId(articleId,likeId);
    }
}
