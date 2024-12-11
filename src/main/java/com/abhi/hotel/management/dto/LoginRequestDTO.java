package com.abhi.hotel.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "Email can not be blank.")
    private String email;

    @NotBlank(message = "Password can not be blank.")
    private String password;
}
