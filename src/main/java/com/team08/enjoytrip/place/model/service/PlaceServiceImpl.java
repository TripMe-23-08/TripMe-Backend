package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.model.dto.PlaceDto;
import com.team08.enjoytrip.place.model.dto.SearchCondition;
import com.team08.enjoytrip.place.model.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlaceServiceImpl implements PlaceService {
    private PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceDto> getAllPlaces(Map<String, String> condition) {
        SearchCondition searchCondition = SearchCondition.builder()
                .sidoCode(condition.get("sido"))
                .gugunCode(condition.get("gugun"))
                .category(condition.get("category"))
                .searchKeyword(condition.get("searchKeyword"))
                .build();
        return placeRepository.findAll(searchCondition);
    }

    @Override
    public PlaceDto getPlace(int id) {
        return placeRepository.findById(id);
    }
}
