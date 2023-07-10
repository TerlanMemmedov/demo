package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeForCreationDto;
import com.example.demo.dto.EmployeeForUpdateDto;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "companies/{companyId}/employees")
@RequiredArgsConstructor
public class EmployeeController
{
    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@PathVariable long companyId)
    {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees(companyId);

        return ResponseEntity.status(HttpStatus.OK).body(employeeDtos);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long companyId, @PathVariable long employeeId)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(companyId, employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> createEmployee
            (@PathVariable long companyId, @RequestBody EmployeeForCreationDto employeeForCreationDto)
    {
        EmployeeDto employeeDto = employeeService.createNewEmployee(companyId, employeeForCreationDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee
            (@PathVariable long companyId, @PathVariable long employeeId, @RequestBody EmployeeForUpdateDto employeeForUpdateDto)
    {
        EmployeeDto employeeDto = employeeService.updateTheEmployee(companyId, employeeId, employeeForUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long companyId, @PathVariable long employeeId)
    {
        String message = employeeService.deleteEmployee(companyId, employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
