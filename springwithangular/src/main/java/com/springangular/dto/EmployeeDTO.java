package com.springangular.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {
	@NotNull(message="Id cannot be null")
	private Integer Id;
	@Size(min=4,max=10,message="invalid user name")	  
	@NotBlank(message="Please enter the name")
	private String Name;
    @NotEmpty(message = "Address cannot empty")
	private String Address;
   
}
