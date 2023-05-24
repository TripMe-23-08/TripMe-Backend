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
        return tripRouteRepository.getAll();
    }

    @Override
    public List<TripRouteDto> getAllUser(int userId) {
        return tripRouteRepository.getAllUser(userId);
    }

    @Override //TODO: 고쳐야하는 부분
    public TripRouteDto get(int id) {
        return tripRouteRepository.get(id);
    }

    @Override
    public void create(TripRouteDto tripRouteDto) {
        tripRouteRepository.create(tripRouteDto);
    }

    public void createPlace(TripPlaceDto tripPlaceDto) {
        tripPlaceRepository.create(tripPlaceDto);
    }

    @Override
    public void update(TripRouteDto tripRouteDto) {
        List<TripPlaceDto> originalPlaces = tripRouteRepository.getAllPlacesByRouteId(tripRouteDto.getId());
        for (int i=0; i<originalPlaces.size(); ++i) {
            TripPlaceDto tripPlaceDto = originalPlaces.get(i);
            tripPlaceRepository.delete(tripPlaceDto.getId());
        }

        for (int i=0; i<tripRouteDto.getTripPlaces().size(); ++i) {
            TripPlaceDto tripPlaceDto = tripRouteDto.getTripPlaces().get(i);
            tripPlaceDto.setTripRouteId(tripRouteDto.getId());
            tripPlaceRepository.create(tripPlaceDto);
        }

        tripRouteRepository.update(tripRouteDto);
    }

    @Override
    public void delete(int id) {
        TripRouteDto tripRouteDto = tripRouteRepository.get(id);
        for (int i=0; i<tripRouteDto.getTripPlaces().size(); ++i) {
            TripPlaceDto tripPlaceDto = tripRouteDto.getTripPlaces().get(i);
            tripPlaceRepository.delete(tripPlaceDto.getId());
        }

        tripRouteRepository.delete(id);
    }

    @Override
    public int getRecentRouteId(int id) {       // recent route id from user id
        return tripRouteRepository.getRecentRouteId(id);
    }

    @Override
    public List<TripPlaceDto> getAllPlacesByRouteId(int id) {
        return tripRouteRepository.getAllPlacesByRouteId(id);
    }
}
