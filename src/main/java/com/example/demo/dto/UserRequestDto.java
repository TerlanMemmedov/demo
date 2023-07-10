package com.example.demo.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto
{
    @NotNull(message = "Username must be provided")
    private String userName;
    private String email;
    private String password;
}
