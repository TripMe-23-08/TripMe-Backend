package com.team08.enjoytrip.place.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.place.model.service.HistoryPlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
public class HistoryPlaceController {
    private HistoryPlaceService historyPlaceService;

    public HistoryPlaceController(HistoryPlaceService historyPlaceService) {
        this.historyPlaceService = historyPlaceService;
    }

    @PostMapping("/places/history")
    public ResponseEntity<ResponseDto> setHistory(@RequestBody Map<String, Object> payload) {
        log.debug("[POST] /places/history : ");

        Map params = (Map) payload.get("params");
        String userId = String.valueOf(params.get("userId"));
        String placeId = String.valueOf(params.get("placeId"));
        log.debug("user id : " + userId + ", place id : " + placeId);

        if (userId != null && placeId != "null") {  // front에서 처리해도 될 듯
            historyPlaceService.setPlaceHistory(Integer.parseInt(userId), Integer.parseInt(placeId));
        } else {}

        return new ResponseEntity<>(new ResponseDto("Place 기록 추가", null), HttpStatus.OK);
    }
}
