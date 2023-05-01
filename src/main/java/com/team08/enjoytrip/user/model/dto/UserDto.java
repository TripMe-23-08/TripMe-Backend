package com.team08.enjoytrip.user.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
public class UserDto {
    private int id;
    @Email
    private String email;
    @NotBlank
    private String password;
    private String name;
    private String nickName;
    private String address;
    private String phoneNumber;
    public UserDto(){
    }
    @Builder
    public UserDto(int id, String email, String password, String name, String nickName, String address, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
