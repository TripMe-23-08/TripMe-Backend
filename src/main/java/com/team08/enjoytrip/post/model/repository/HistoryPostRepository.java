package com.team08.enjoytrip.post.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HistoryPostRepository {
    void setPostHistory(@Param("user_id") int userId, @Param("post_id") int postId);
    void delete(int postId);
}
