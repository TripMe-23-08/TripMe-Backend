package com.team08.enjoytrip.post.model.service;

import com.team08.enjoytrip.post.model.repository.HistoryPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class HistoryPostServiceImpl implements HistoryPostService {
    private HistoryPostRepository historyPostRepository;

    public HistoryPostServiceImpl(HistoryPostRepository historyPostRepository) {
        this.historyPostRepository = historyPostRepository;
    }

    @Override
    public void setPostHistory(int userId, int postId) {
        // update post history

        historyPostRepository.setPostHistory(userId, postId);
    }

}
