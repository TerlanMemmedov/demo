package com.example.demo.repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
//    @Query("SELECT emps FROM Employee emps WHERE emps.company.companyId = ?1")
//    List<Employee> findEmployeesByCompanyId(String companyId);

    List<Employee> findEmployeeByCompany(Company company);
}
