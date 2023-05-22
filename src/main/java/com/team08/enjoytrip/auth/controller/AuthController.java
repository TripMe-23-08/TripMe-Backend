package com.team08.enjoytrip.auth.controller;

import com.team08.enjoytrip.auth.exception.InvalidTokenException;
import com.team08.enjoytrip.auth.model.dto.JwtDto;
import com.team08.enjoytrip.auth.model.service.AuthService;
import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.common.exception.UnauthorizedException;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.auth.model.dto.LoginRequestDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@Slf4j
@RestController
public class AuthController { // http://localhost:8080/api/v1/
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody @Valid LoginRequestDto requestDto) throws UserNotFoundException {
        log.debug("[POST] /login :" + requestDto.toString());
        JwtDto jwt = authService.login(requestDto.getEmail(), requestDto.getPassword());
        authService.saveRefreshToken(jwt);
        return new ResponseEntity<>(new ResponseDto("로그인에 성공하셨습니다.", jwt), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(HttpServletRequest request) {
        //token 무효화
        String token = request.getHeader("Authorization");
        Map<String, Object> claims = authService.getClaimsFromToken(token);
        int userId = (int) claims.get("userId");
        authService.logout(userId);
        return new ResponseEntity<>(new ResponseDto("로그아웃에 성공하셨습니다.", null), HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) throws InvalidTokenException {
        String token = request.getHeader("Authorization");
        Map<String, Object> claims = authService.getClaimsFromToken(token);
        String savedToken = authService.getSavedTokenByUserId((int)claims.get("userId"));
        if (token.equals(savedToken)) {
            String accessToken = authService.createAccessToken(claims);
            return new ResponseEntity<>(new ResponseDto("AccessToken 재발급 성공", accessToken), HttpStatus.OK);
        }
        throw new InvalidTokenException("RefreshToken 이상함");
    }
}
