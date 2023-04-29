package com.team08.enjoytrip.user.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequestDto {
    @Email
    private String email;
    @NotBlank
    private String password;
}
