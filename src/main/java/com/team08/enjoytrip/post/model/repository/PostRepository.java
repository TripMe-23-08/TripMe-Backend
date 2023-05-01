package com.team08.enjoytrip.post.model.repository;

import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {
    PostDto findById(int postId);

    List<PostDto> findAllByUserId(int userId);

    int save(PostDto postDto);

    int update(PostDto postDto);

    int delete(PostDto postDto);
}
