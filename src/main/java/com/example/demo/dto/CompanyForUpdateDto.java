package com.example.demo.dto;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyForUpdateDto
{
    @NotNull(message = "Name can't be null")
    private String name;
    private String address;
    private String country;
}
