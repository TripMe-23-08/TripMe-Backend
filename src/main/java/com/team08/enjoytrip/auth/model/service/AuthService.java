package com.team08.enjoytrip.auth.model.service;

import com.team08.enjoytrip.auth.model.dto.JwtDto;
import com.team08.enjoytrip.user.exception.UserNotFoundException;

import java.util.Map;

public interface AuthService {
    JwtDto login(String email, String password) throws UserNotFoundException; // 로그인 -> JWT토큰발행
    void logout(int userId); //로그아웃

    void saveRefreshToken(JwtDto jwtDto); // refreshToken

    Map<String, Object> getClaimsFromToken(String token);

    String getSavedTokenByUserId(int userId);

    String createAccessToken(Map<String, Object> claims);
}
