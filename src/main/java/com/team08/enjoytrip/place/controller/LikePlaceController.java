package com.team08.enjoytrip.place.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.place.exception.PlaceNotFoundException;
import com.team08.enjoytrip.place.model.dto.LikePlaceDto;
import com.team08.enjoytrip.place.model.dto.PlaceDto;
import com.team08.enjoytrip.place.model.service.LikePlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/like-places")
public class LikePlaceController {
    private LikePlaceService likePlaceService;

    public LikePlaceController(LikePlaceService likePlaceService) {
        this.likePlaceService = likePlaceService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addAsLikePlace(@RequestBody LikePlaceDto likePlaceDto) throws PlaceNotFoundException{
        log.debug("[POST] /like-places " + likePlaceDto);
        // TODO: 좋아요 한번만 수행하도록 검증 로직 추가
        likePlaceService.addLikePlace(likePlaceDto);
        return new ResponseEntity<>(new ResponseDto("좋아하는 장소에 추가", likePlaceDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getLikedPlace(@RequestParam int userId) {
        log.debug("[GET] /like-places  userId" + userId);
        List<PlaceDto> userLikedPlaces = likePlaceService.getUserLikedPlace(userId);
        return new ResponseEntity<>(new ResponseDto(userId + "가 좋아하는 장소 조회", userLikedPlaces), HttpStatus.OK);
    }


    @DeleteMapping("/{likePlaceId}")
    public ResponseEntity<ResponseDto> deleteLikedPlace(@PathVariable int likePlaceId) throws PlaceNotFoundException {
        log.debug("[DELETE] /like-places/" + likePlaceId);
        likePlaceService.deleteLikedPlace(likePlaceId);
        return new ResponseEntity<>(new ResponseDto("좋아하는 장소" + likePlaceId + " 취소", null), HttpStatus.OK);
    }

}
