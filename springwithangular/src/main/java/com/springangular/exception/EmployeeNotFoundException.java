package com.springangular.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String message) {
		super(message);
		
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		
	}

	

}
