package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.model.dto.PlaceDto;

import java.util.List;
import java.util.Map;

public interface PlaceService {
    List<PlaceDto> getAllPlaces(Map<String, String> condition);
    List<PlaceDto> getAllPlacesUserHistory(int userId);
    PlaceDto getPlace(int id);
}
