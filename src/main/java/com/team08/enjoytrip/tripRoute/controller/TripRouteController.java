package com.team08.enjoytrip.tripRoute.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;
import com.team08.enjoytrip.tripRoute.model.service.TripRouteService;
import com.team08.enjoytrip.user.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/trip-routes")
public class TripRouteController {
    private TripRouteService tripRouteService;

    public TripRouteController(TripRouteService tripRouteService) {
        this.tripRouteService = tripRouteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> get(@PathVariable int id) {
        log.debug("[GET] /trip-routes/" + id);

        TripRouteDto tripRouteDto = tripRouteService.get(id);

        return new ResponseEntity<>(new ResponseDto("trip route 조회 완료 ", tripRouteDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody TripRouteDto tripRouteDto) {
        log.debug("[POST] /trip-routes/");

        // sample data for test
        String testUrl = "example url path here";
        int testUserId = 3;

        tripRouteDto.setTripImgUrl(testUrl);
        tripRouteDto.setUserId(testUserId);

        log.debug(tripRouteDto.toString());
        tripRouteService.create(tripRouteDto);
        return new ResponseEntity<>(new ResponseDto("trip 생성 완료", null), HttpStatus.OK);
    }

}
