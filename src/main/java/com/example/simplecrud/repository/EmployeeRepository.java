package com.example.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplecrud.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}