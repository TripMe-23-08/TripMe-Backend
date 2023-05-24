package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.model.dto.PlaceDto;
import com.team08.enjoytrip.place.model.dto.PlaceSearchCondition;
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
        PlaceSearchCondition searchCondition = PlaceSearchCondition.builder()
                .sidoCode(condition.get("sido"))
                .gugunCode(condition.get("gugun"))
                .category(condition.get("category"))
                .searchKeyword(condition.get("searchKeyword"))
                .limitCount(condition.get("limit") == null ? null : Integer.parseInt(condition.get("limit")))
                .onlyWithImage(condition.get("image"))
                .offset(condition.get("offset") == null ? null : Integer.parseInt(condition.get("offset")))
                .build();
        return placeRepository.findAll(searchCondition);
    }

    @Override
    public List<PlaceDto> getAllPlacesUserHistory(int userId) {
        return placeRepository.findAllUserHistory(userId);
    }

    @Override
    public PlaceDto getPlace(int id) {
        return placeRepository.findById(id);
    }
}
