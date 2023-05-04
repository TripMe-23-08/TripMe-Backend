package com.team08.enjoytrip.auth.controller;

import com.team08.enjoytrip.auth.model.service.AuthService;
import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.auth.model.dto.LoginRequestDto;
import com.team08.enjoytrip.user.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@Slf4j
@RestController
public class AuthController { // http://localhost:8080/api/v1/
    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody @Valid LoginRequestDto requestDto) throws UserNotFoundException {
        log.debug("[POST] /login :"+requestDto.toString());
        String jwt = authService.login(requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(new ResponseDto("로그인에 성공하셨습니다.",jwt), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(HttpSession session){
        //token 무효화
        //userService.logout();
        return new ResponseEntity<>(new ResponseDto("로그인에 성공하셨습니다.",null), HttpStatus.OK);
    }
}
