package com.example.demo.mapper;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.CompanyForCreationDto;
import com.example.demo.dto.CompanyForUpdateDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy =  InjectionStrategy.CONSTRUCTOR)
public interface CompanyMapper
{
    default List<CompanyDto> mapFromCompaniesToCompanyDtos(List<Company> companies) {
        if(companies == null){return null;}

        List<CompanyDto> list = new ArrayList<CompanyDto>(companies.size());
        for(Company company : companies)
        {
            list.add(mapFromCompanyToCompanyDto(company));
        }

        return list;
    }

    default CompanyDto mapFromCompanyToCompanyDto(Company company) {
        if(company == null){return null;}

        CompanyDto.CompanyDtoBuilder companyDto = CompanyDto.builder();

        companyDto.name(company.getName());
        companyDto.country(company.getCountry());
        companyDto.address(company.getAddress());

        return companyDto.build();
    }

    default Company mapFromCompanyForCreationDtoToCompany(CompanyForCreationDto companyForCreationDto) {
        if(companyForCreationDto == null){return null;}

        Company.CompanyBuilder company = Company.builder();

        company.name(companyForCreationDto.getName());
        company.address(companyForCreationDto.getAddress());
        company.country(companyForCreationDto.getCountry());

        return company.build();
    }

    default Company mapFromCompanyForUpdateDtoToCompany(CompanyForUpdateDto companyForUpdateDto)
    {
        if(companyForUpdateDto == null){return null;}

        Company.CompanyBuilder company = Company.builder();

        company.name(companyForUpdateDto.getName());
        company.address(companyForUpdateDto.getAddress());
        company.country(companyForUpdateDto.getCountry());

        return company.build();
    }
}
