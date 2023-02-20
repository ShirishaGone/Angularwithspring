package com.springangular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springangular.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
