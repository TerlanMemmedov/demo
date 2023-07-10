package com.example.demo.exception;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RequiredArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException
{
    public CompanyNotFoundException(long companyId)
    {
        super("Company not found");
    }
}
