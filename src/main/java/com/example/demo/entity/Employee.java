package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EMPLOYEE")
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "POSITION")
    private String position;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

}
