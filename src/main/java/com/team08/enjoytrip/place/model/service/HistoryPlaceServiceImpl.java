package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.model.repository.HistoryPlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryPlaceServiceImpl implements HistoryPlaceService {
    private HistoryPlaceRepository historyPlaceRepository;

    public HistoryPlaceServiceImpl(HistoryPlaceRepository historyPlaceRepository) {
        this.historyPlaceRepository = historyPlaceRepository;
    }

    @Override
    public void setPlaceHistory(int userId, int placeId) {
        historyPlaceRepository.setPlaceHistory(userId, placeId);
    }
}
