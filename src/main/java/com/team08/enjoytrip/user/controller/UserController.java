package com.team08.enjoytrip.user.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.user.exception.UserAlreadyExistException;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.LoginRequestDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserController { // http://localhost:8080/api/v1/
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signUp(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        log.debug("[POST] /signup :"+userDto.toString());
        userService.signup(userDto);
        return new ResponseEntity<>(new ResponseDto("회원가입에 성공하셨습니다.",null), HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequestDto requestDto) throws UserNotFoundException {
        userService.login(requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(new ResponseDto("로그인에 실패하셨습니다.",null), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(){
        userService.logout();
        return new ResponseEntity<>(new ResponseDto("잘못된 요청입니다.",null), HttpStatus.BAD_REQUEST);
    }
}
