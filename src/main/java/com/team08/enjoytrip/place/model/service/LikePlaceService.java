package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.exception.PlaceNotFoundException;
import com.team08.enjoytrip.place.model.dto.LikePlaceDto;
import com.team08.enjoytrip.place.model.dto.PlaceDto;

import java.util.List;

public interface LikePlaceService {
    void addLikePlace(LikePlaceDto likePlaceDto) throws PlaceNotFoundException;

    List<PlaceDto> getUserLikedPlace(int userId);

    void deleteLikedPlace(int likePlaceId) throws PlaceNotFoundException;
}
