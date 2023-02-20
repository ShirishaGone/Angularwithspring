package com.springangular.service;

import java.util.List;

import com.springangular.dto.EmployeeDTO;
import com.springangular.entity.Employee;

public interface EmployeeService {
  Employee addEmployee(EmployeeDTO  employeeDTO);
  Employee getEmployeeById(int employeeId);
  List<Employee> showEmployees();
  public String updateEmployee(EmployeeDTO params,int employeeId);
	 public String deletemployeeById(int employeeId);
	 public String deleteAllEmployees();

}
