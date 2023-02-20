package com.springangular.service;

import java.util.List;

import org.apache.catalina.User;

import com.springangular.dto.UserDTO;

public interface UserService {
	User addUser(UserDTO userDTO);
	 User getUserById(int userId);
	  List<User> showUsers();
	  public String updateUser(int bookId,UserDTO params);
		 public String deleteUserById(int userId);
		 public String deleteAllUsers();
}
