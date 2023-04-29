package com.team08.enjoytrip.user.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
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
}
