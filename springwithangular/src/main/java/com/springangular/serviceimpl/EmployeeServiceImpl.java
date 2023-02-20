package com.springangular.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springangular.dto.EmployeeDTO;
import com.springangular.entity.Employee;
import com.springangular.repositories.EmployeeRepository;
import com.springangular.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(EmployeeDTO employeeDTO) {
		Employee employee=Employee.builder()
				.employeeId(employeeDTO.getEmployeeId())
				.employeename(employeeDTO.getEmployeeName())
				.employeeaddress(employeeDTO.getEmployeeAddress())
				.build();
		return employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
;
	}

	@Override
	public List<Employee> showEmployees() {
		return employeeRepository.findAll();

	}

	@Override
	public String updateEmployee(EmployeeDTO employeeDTO, int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).get();
		Employee employee1=Employee.builder()
		                           .employeeName(employeeDTO.getName())
		                           .employeeAddress(employeeDTO.getAddress())
		                           .build();
	        return "updated successfully";

	}

	@Override
	public String deletemployeeById(int employeeId) {
		employeeRepository.deleteById(employeeId);
		return "The employee id is deleted"+employeeId;
	}

	@Override
	public String deleteAllEmployees() {
		employeeRepository.deleteAll();
		return "Deleted successfully";	}
  }
