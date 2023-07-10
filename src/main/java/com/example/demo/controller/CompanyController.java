package com.example.demo.controller;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.CompanyForCreationDto;
import com.example.demo.dto.CompanyForUpdateDto;
import com.example.demo.exception.CompanyNotFoundException;
import com.example.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController
{
    private final CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<List<CompanyDto>> getAllCompanies()
    {
        List<CompanyDto> companyDtos = companyService.getAllCompanies();
        return ResponseEntity.status(HttpStatus.OK).body(companyDtos);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable long companyId) throws CompanyNotFoundException
    {
        CompanyDto companyDto = companyService.getCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(companyDto);
    }

    @PostMapping("/")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyForCreationDto companyForCreationDto)
    {
        CompanyDto companyDto = companyService.createNewCompany(companyForCreationDto);
        return ResponseEntity.status(HttpStatus.OK).body(companyDto);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany
            (@PathVariable long companyId, @RequestBody CompanyForUpdateDto companyForUpdateDto)
    {
        CompanyDto companyDto = companyService.updateCompany(companyId, companyForUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(companyDto);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable long companyId)
    {
        String message = companyService.deleteCompanyById(companyId);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
