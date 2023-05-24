package com.team08.enjoytrip.post.model.repository;

import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.post.model.dto.PostRequestDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostRepository {
    void save(PostRequestDto postRequestDto);

    void update(PostDto postDto);

    PostDto findById(int articleId);

    List<PostDto> findAll(); //TODO: searchCondition 추가
    List<PostDto> findAllUser(int userId);
    List<PostDto> findAllUserHistory(int userId);
    void delete(int articleId);

}
