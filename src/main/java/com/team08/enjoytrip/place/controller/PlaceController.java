package com.team08.enjoytrip.place.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.place.model.dto.PlaceDto;
import com.team08.enjoytrip.place.model.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto> searchAllPlaces(@RequestParam Map<String, String>conditions) {
        log.debug("[GET] /places "+conditions.toString());

        List<PlaceDto> allPlaces = placeService.getAllPlaces(conditions);
        return new ResponseEntity<>(new ResponseDto("모든 관광지 조회: searchCondition", allPlaces), HttpStatus.OK);
    }

    @GetMapping("/user-history/{userId}")
    public ResponseEntity<ResponseDto> searchAllPlaces(@PathVariable int userId) {
        log.debug("[GET] /places/user-history/ "+userId);

        List<PlaceDto> allPlaces = placeService.getAllPlacesUserHistory(userId);
        return new ResponseEntity<>(new ResponseDto("유저 히스토리 장소 조회 완료", allPlaces), HttpStatus.OK);
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<ResponseDto> searchPlaceInfo(@PathVariable int placeId) {
        log.debug("[GET] /places/" + placeId);
        PlaceDto place = placeService.getPlace(placeId);
        return new ResponseEntity<>(new ResponseDto("관광지 조회: ", place), HttpStatus.OK);
    }
}
