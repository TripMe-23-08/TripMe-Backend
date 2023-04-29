package com.team08.enjoytrip.user.model.dto;

import lombok.*;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String address;
    private String phoneNumber;
}
