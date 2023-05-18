package com.team08.enjoytrip.auth.model.service;

import com.team08.enjoytrip.auth.JwtUtil;
import com.team08.enjoytrip.auth.model.dto.JwtDto;
import com.team08.enjoytrip.auth.model.repository.AuthRepository;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    private JwtUtil jwtUtil;
    private AuthRepository authRepository;

    public AuthServiceImpl(JwtUtil jwtUtil, AuthRepository authRepository) {
        this.jwtUtil = jwtUtil;
        this.authRepository = authRepository;
    }

    @Override
    public JwtDto login(String email, String password) {
        UserDto userDto = authRepository.findByEmail(email);
        if (BCrypt.checkpw(password, userDto.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", userDto.getId());
            claims.put("userEmail", userDto.getEmail());
            claims.put("userName", userDto.getName());
            String accessToken = jwtUtil.generateToken("access-token", claims, 1000 * 60 * 60 * 1); // 1시간
            String refreshToken = jwtUtil.generateToken("refresh-token", claims, 1000 * 60 * 60 * 10); // DB에 넣어서 관리
            return new JwtDto(userDto.getId(),accessToken, refreshToken);
        }
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }

    @Override
    public void logout(int userId) {
        authRepository.delete(userId);// refreshToken 삭제
    }

    @Override
    public void saveRefreshToken(JwtDto jwtDto) {
        authRepository.save(jwtDto); // userId가 존재시, update token
    }

    @Override
    public Map<String, Object> getClaimsFromToken(String token) {
        return jwtUtil.getClaims(token);
    }

    @Override
    public String getSavedTokenByUserId(int userId) {
        return authRepository.findById( userId);
    }

    @Override
    public String createAccessToken(Map<String, Object> claims) {
        return jwtUtil.generateToken("access-token",claims,1000 * 60 * 60 * 1);
    }
}
