package com.team08.enjoytrip.tripRoute.model.service;

import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;

import java.util.List;

public interface TripRouteService {
    List<TripRouteDto> getAll();
    TripRouteDto get(int id);
    void create(TripRouteDto tripRouteDto);
    void update(TripRouteDto tripRouteDto);
    void delete(int id);
}
