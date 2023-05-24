package com.team08.enjoytrip.tripRoute.model.service;

import com.team08.enjoytrip.tripRoute.model.dto.TripPlaceDto;
import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;

import java.util.List;

public interface TripRouteService {
    List<TripRouteDto> getAll();
    List<TripRouteDto> getAllUser(int userId);
    TripRouteDto get(int id);
    void create(TripRouteDto tripRouteDto);
    void createPlace(TripPlaceDto tripPlaceDto);
    void update(TripRouteDto tripRouteDto);
    void delete(int id);
    int getRecentRouteId(int id);

    List<TripPlaceDto> getAllPlacesByRouteId(int id);
}
