package com.team08.enjoytrip.user.model.repository;

import com.team08.enjoytrip.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserDto findByEmail(String email);
    int save(UserDto userDto);
}
