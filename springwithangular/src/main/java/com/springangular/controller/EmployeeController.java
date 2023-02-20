package com.springangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springangular.dto.EmployeeDTO;
import com.springangular.entity.Employee;
import com.springangular.exception.EmployeeNotFoundException;
import com.springangular.service.EmployeeService;
import com.springangular.serviceimpl.EmployeeServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	@Autowired
    private EmployeeServiceImpl employeeServiceImpl;
	@PostMapping("/addemployees")
	ResponseEntity<Employee> insertEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		try
		{
			Employee employee=employeeServiceImpl.addEmployee(employeeDTO);
			 if(employee!=null) 
			 {
	           return new ResponseEntity<Employee> (employee,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex)
		{
			throw new EmployeeNotFoundException("Not able to handle the employee");
		}
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		
		@GetMapping("/getemployeeById/{employeeId}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId)
		{
			try {
				Employee employee=employeeServiceImpl.getEmployeeById(employeeId);
				if(employee!=null) 
				{
			      return new ResponseEntity<Employee>(employee,HttpStatus.OK);
				}
			}
			catch(Exception e)
			{
				throw new EmployeeNotFoundException("No such employee with id "+employeeId);
			}
			 return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			
		 }
		
		 @PutMapping(path="/updateEmployeeById/{employeeId}")
		 public ResponseEntity<String> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO , @PathVariable Integer employeeId)
			{
			 try
				{
				 String employee=employeeServiceImpl.updateEmployee(employeeDTO, employeeId);
				 if(employee!=null)
				  {
			       return new ResponseEntity<String>(employee,HttpStatus.CREATED);
				  }
				}
				catch(Exception e)
				{
					throw new EmployeeNotFoundException("Not update the employee details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);	
			}
		 @DeleteMapping(path="/deleteEmployeeById/{employeeId}")
		 public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId)
			{
			 try 
				{
				 String employee=employeeServiceImpl.deletemployeeById(employeeId);
				 if(employee!=null)
				   {
					 return new ResponseEntity<String>(employee,HttpStatus.OK);
			       }
				}
				catch(Exception e)
				{
					throw new EmployeeNotFoundException("Not deleted the employee details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		 }

	
}


