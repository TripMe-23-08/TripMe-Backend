package com.team08.enjoytrip.post.model.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikePostRepository {
    void save(int postId, int userId);
    void delete(int id);

    void deleteByArticleIdAndUserId(int postId, int userId);
}
