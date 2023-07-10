package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeForCreationDto;
import com.example.demo.dto.EmployeeForUpdateDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmployeeService
{
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private void CheckCompany(long companyId)
    {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
    }
    private Company CheckAndReturnCompany(long companyId)
    {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
        return company;
    }

    public List<EmployeeDto> getAllEmployees(long companyId)
    {
        Company company = CheckAndReturnCompany(companyId);

        List<Employee> employees = employeeRepository.findEmployeeByCompany(company);
        List<EmployeeDto> employeeDtos = employeeMapper.mapFromEmployeesToEmployeeDtos(employees);

        return employeeDtos;
    }

    public EmployeeDto getEmployeeById(long companyId, long employeeId)
    {
        CheckCompany(companyId);

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeDto employeeDto = employeeMapper.mapFromEmployeeToEmployeeDto(employee);

        return employeeDto;
    }
//
    public EmployeeDto createNewEmployee(long companyId, EmployeeForCreationDto employeeForCreationDto)
    {
        Company company = CheckAndReturnCompany(companyId);

        Employee employee = employeeMapper.mapFromEmployeeForCreationDtoToEmployee(employeeForCreationDto);
        employee.setCompany(company);
        employeeRepository.save(employee);

        EmployeeDto employeeDto = employeeMapper.mapFromEmployeeToEmployeeDto(employee);
        return employeeDto;
    }

    public EmployeeDto updateTheEmployee(long companyId, long employeeId, EmployeeForUpdateDto employeeForUpdateDto)
    {
        Company company = CheckAndReturnCompany(companyId);

        Employee employee = employeeMapper.mapFromEmployeeForUpdateDtoToEmployee(employeeForUpdateDto);
        employee.setCompany(company);
        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);

        EmployeeDto employeeDto = employeeMapper.mapFromEmployeeToEmployeeDto(employee);
        return employeeDto;
    }

    public String deleteEmployee(long companyId, long employeeId)
    {
        CheckCompany(companyId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);

        return String.format("Company with the given id: %d is deleted", employeeId);
    }
}
