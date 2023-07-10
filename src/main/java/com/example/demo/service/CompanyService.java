package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.CompanyForCreationDto;
import com.example.demo.dto.CompanyForUpdateDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.exception.CompanyNotFoundException;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.repository.CompanyRepository;
import liquibase.repackaged.org.apache.commons.lang3.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CompanyService
{
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    private Company CheckAndReturnCompany(long companyId)
    {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException(companyId));
        return company;
    }

    public List<CompanyDto> getAllCompanies()
    {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDto> companyDtos = companyMapper.mapFromCompaniesToCompanyDtos(companies);

        return companyDtos;
    }

    public CompanyDto getCompanyById(long companyId)
    {
        Company company = CheckAndReturnCompany(companyId);
        CompanyDto companyDto = companyMapper.mapFromCompanyToCompanyDto(company);

        return companyDto;
    }

    public CompanyDto createNewCompany(CompanyForCreationDto companyForCreationDto)
    {
        Company company = companyMapper.mapFromCompanyForCreationDtoToCompany(companyForCreationDto);
        companyRepository.save(company);

        CompanyDto companyDto = companyMapper.mapFromCompanyToCompanyDto(company);
        return companyDto;
    }

    public CompanyDto updateCompany(long companyId, CompanyForUpdateDto companyForUpdateDto)
    {
        Company company = CheckAndReturnCompany(companyId);

        company = companyMapper.mapFromCompanyForUpdateDtoToCompany(companyForUpdateDto);
        company.setCompanyId(companyId);
        companyRepository.save(company);

        CompanyDto companyDto = companyMapper.mapFromCompanyToCompanyDto(company);
        return companyDto;
    }

    public String deleteCompanyById(long companyId)
    {
        Company company = CheckAndReturnCompany(companyId);
        companyRepository.delete(company);

        return String.format("Company with the given id: %d is deleted", companyId);
    }

}
