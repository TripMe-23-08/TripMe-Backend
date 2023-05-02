package com.team08.enjoytrip.tripRoute.model.service;

import com.team08.enjoytrip.tripRoute.model.dto.TripPlaceDto;
import com.team08.enjoytrip.tripRoute.model.repository.TripPlaceRepository;
import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;
import com.team08.enjoytrip.tripRoute.model.repository.TripRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripRouteServiceImpl implements TripRouteService{

    private TripRouteRepository tripRouteRepository;
    private TripPlaceRepository tripPlaceRepository;

    public TripRouteServiceImpl(TripRouteRepository tripRouteRepository, TripPlaceRepository tripPlaceRepository) {
        this.tripRouteRepository = tripRouteRepository;
        this.tripPlaceRepository = tripPlaceRepository;
    }

    @Override
    public List<TripRouteDto> getAll() {
        return null;
    }

    @Override
    public TripRouteDto get(int id) {
        return tripRouteRepository.get(id);
    }

    @Override
    public void create(TripRouteDto tripRouteDto) {
        tripRouteRepository.create(tripRouteDto);

        for (int i=0; i<tripRouteDto.getTripPlaces().size(); i++) {
            TripPlaceDto tripPlaceDto = tripRouteDto.getTripPlaces().get(i);
            tripPlaceDto.setTripRouteId(tripRouteDto.getId());
            tripPlaceRepository.create(tripPlaceDto);
        }

    }

    @Override
    public void update(TripRouteDto tripRouteDto) {

    }

    @Override
    public void delete(int id) {

    }
}
