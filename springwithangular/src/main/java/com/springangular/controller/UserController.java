package com.springangular.controller;

import org.apache.catalina.User;
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

import com.springangular.dto.UserDTO;
import com.springangular.exception.UserNotFoundException;
import com.springangular.serviceimpl.UserServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	@Autowired
    private UserServiceImpl userServiceImpl;
	@PostMapping("/addusers")
	ResponseEntity<User> insertUser(@RequestBody @Valid UserDTO userDTO) {
		try
		{
			User user=userServiceImpl.addUser(userDTO);
			 if(user!=null) 
			 {
	           return new ResponseEntity<User> (user,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex)
		{
			throw new UserNotFoundException("Not able to handle the user");
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		
		@GetMapping("/getuserById/{userId}")
		public ResponseEntity<User> getUserById(@PathVariable Integer userId)
		{
			try {
				User user=userServiceImpl.getUserById(userId);
				if(user!=null) 
				{
			      return new ResponseEntity<User>(user,HttpStatus.OK);
				}
			}
			catch(Exception ex)
			{
				throw new UserNotFoundException("No such user with id "+userId);
			}
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
		 }
		
		 @PutMapping(path="/updateUserById/{userId}")
		 public ResponseEntity<String> updateUser(@RequestBody @Valid UserDTO userDTO , @PathVariable Integer userId)
			{
			 try
				{
				 String user=userServiceImpl.updateUser(userDTO, userId);
				 if(user!=null)
				  {
			       return new ResponseEntity<String>(user,HttpStatus.CREATED);
				  }
				}
				catch(Exception e)
				{
					throw new UserNotFoundException("Not update the user details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);	
			}
		 @DeleteMapping(path="/deleteUserById/{userId}")
		 public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId)
			{
			 try 
				{
				 String user=userServiceImpl.deleteUserById(userId);
				 if(user!=null)
				   {
					 return new ResponseEntity<String>(user,HttpStatus.OK);
			       }
				}
				catch(Exception e)
				{
					throw new UserNotFoundException("Not deleted the user details");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		 }

	
}

