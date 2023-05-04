package com.team08.enjoytrip.auth.model.repository;

import com.team08.enjoytrip.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthRepository {
    UserDto findByEmail(String email);
}
