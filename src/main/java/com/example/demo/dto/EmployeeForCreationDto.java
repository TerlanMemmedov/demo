package com.example.demo.dto;


import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeForCreationDto
{
    private String name;
    private Integer age;
    private String position;
}
