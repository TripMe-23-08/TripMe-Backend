package com.team08.enjoytrip.post.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.post.model.service.HistoryPostService;
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
public class HistoryPostController {
    private HistoryPostService historyPostService;

    public HistoryPostController(HistoryPostService historyPostService) {
        this.historyPostService = historyPostService;
    }
    @PostMapping("/articles/history")
    public ResponseEntity<ResponseDto> setHistory(@RequestBody Map<String, Object> payLoad) {
        log.debug("[POST] /articles/history : ");

        Map params = (Map) payLoad.get("params");
        String userId = String.valueOf(params.get("userId"));
        String postId = String.valueOf(params.get("postId"));

        historyPostService.setPostHistory(Integer.parseInt(userId), Integer.parseInt(postId));

        return new ResponseEntity<>(new ResponseDto("Post 기록 추가", null), HttpStatus.OK);
    }
}
