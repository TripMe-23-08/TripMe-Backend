package com.team08.enjoytrip.post.model.service;

import com.team08.enjoytrip.post.exception.ArticleNotFoundException;
import com.team08.enjoytrip.post.model.dto.PostDto;
import com.team08.enjoytrip.post.model.repository.PostRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addArticle(PostDto postDto) throws ArticleNotFoundException {
        postRepository.save(postDto);
    }

    @Override
    public void modifyArticle(PostDto postDto) throws ArticleNotFoundException {
        postRepository.update(postDto);
        // throw new ArticleNotFoundException("글"+postDto.getId()+"가 존재하지 않습니다.");
    }



    @Override
    public PostDto searchArticle(int articleId) throws ArticleNotFoundException {
        PostDto postDto = postRepository.findById(articleId);
        if (postDto == null) {
            throw new ArticleNotFoundException("" + articleId + "가 없습니다.");
        }
        return postDto;
    }

    @Override
    public List<PostDto> searchArticles() {
        return postRepository.findAll();
    }

    @Override
    public void delete(int articleId) {
        postRepository.delete(articleId);
    }

    private boolean isExist(PostDto postDto) {
        PostDto data = postRepository.findById(postDto.getId());
        if (data != null) {
            return true;
        }
        return false;
    }
}
