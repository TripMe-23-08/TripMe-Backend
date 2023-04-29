package com.team08.enjoytrip.user.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.user.model.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController { // http://localhost:8080/api/v1/
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signUp(){

        return new ResponseEntity<>(new ResponseDto("회원가입에 성공하셨습니다.",null), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(){
        return new ResponseEntity<>(new ResponseDto("회원가입에 성공하셨습니다.",null), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(){
        return new ResponseEntity<>(new ResponseDto("회원가입에 성공하셨습니다.",null), HttpStatus.OK);
    }
}
