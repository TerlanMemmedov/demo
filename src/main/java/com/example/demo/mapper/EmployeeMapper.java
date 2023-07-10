package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeForCreationDto;
import com.example.demo.dto.EmployeeForUpdateDto;
import com.example.demo.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy =  InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper
{
    default List<EmployeeDto> mapFromEmployeesToEmployeeDtos(List<Employee> employees)
    {
        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( mapFromEmployeeToEmployeeDto( employee ) );
        }

        return list;
    }

    default EmployeeDto mapFromEmployeeToEmployeeDto(Employee employee)
    {
        EmployeeDto.EmployeeDtoBuilder employeeDto = EmployeeDto.builder();
        employeeDto.name( employee.getName() );
        employeeDto.age( employee.getAge() );
        employeeDto.position( employee.getPosition() );

        return employeeDto.build();
    }

    default Employee mapFromEmployeeForCreationDtoToEmployee(EmployeeForCreationDto employeeForCreationDto)
    {
        Employee.EmployeeBuilder employee = Employee.builder();
        employee.name(employeeForCreationDto.getName());
        employee.age(employeeForCreationDto.getAge());
        employee.position(employeeForCreationDto.getPosition());

        return employee.build();
    }

    default Employee mapFromEmployeeForUpdateDtoToEmployee(EmployeeForUpdateDto employeeForUpdateDto)
    {
        Employee.EmployeeBuilder employee = Employee.builder();
        employee.name(employeeForUpdateDto.getName());
        employee.age(employeeForUpdateDto.getAge());
        employee.position(employeeForUpdateDto.getPosition());

        return employee.build();
    }
}
