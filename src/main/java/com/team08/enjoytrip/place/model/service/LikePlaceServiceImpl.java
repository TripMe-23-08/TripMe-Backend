package com.team08.enjoytrip.place.model.service;

import com.team08.enjoytrip.place.exception.PlaceNotFoundException;
import com.team08.enjoytrip.place.model.dto.LikePlaceDto;
import com.team08.enjoytrip.place.model.dto.PlaceDto;
import com.team08.enjoytrip.place.model.repository.LikePlaceRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class LikePlaceServiceImpl implements LikePlaceService {
    private LikePlaceRepository likePlaceRepository;

    public LikePlaceServiceImpl(LikePlaceRepository likePlaceRepository) {
        this.likePlaceRepository = likePlaceRepository;
    }

    @Override
    public void addLikePlace(LikePlaceDto likePlaceDto) throws PlaceNotFoundException {
        likePlaceRepository.save(likePlaceDto);
    }

    @Override
    public List<PlaceDto> getUserLikedPlace(int userId) {
        try {
            return likePlaceRepository.findAllByUserId(userId);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new PlaceNotFoundException("장소를 찾을 수 없습니다.");
        }
    }

    @Override
    public void deleteLikedPlace(int id) throws PlaceNotFoundException {
        if (!isExist(id)) {
            throw new PlaceNotFoundException("장소를 찾을 수 없습니다.");
        }
        likePlaceRepository.delete(id);

    }

    private boolean isExist(int likePlaceId) {
        LikePlaceDto likePlaceDto = likePlaceRepository.findById(likePlaceId);
        if (likePlaceDto != null) {
            return true;
        }
        return false;
    }
}
