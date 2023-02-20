package com.springangular.serviceimpl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.springangular.dto.UserDTO;
import com.springangular.entity.Employee;
import com.springangular.repositories.UserRepository;
import com.springangular.service.UserService;

public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

@Override
public User addUser(UserDTO userDTO) {
	User user=user.builder()
			.userId(userDTO.getId())
			.username(userDTO.getName())
			.useremail(userDTO.getEmail())
			.build();
	return userRepository.add(user);

}

@Override
public User getUserById(int userId) {
	return userRepository.findById(Id).get();
}

@Override
public List<User> showUsers() {
	return userRepository.findAll();
}

public String updateUser(UserDTO params, int userId) {
	User user=userRepository.findById(userId).get()
	.userName(params.getName())
	.userEmail(params.getEmail())
	.build();
    return "updated successfully";

}

@Override
public String deleteUserById(int userId) {
	userRepository.deleteById(userId);
	return "The user id is deleted"+userId;
}

@Override
public String deleteAllUsers() {
	userRepository.deleteAll();
	return "Deleted successfully";

}
	
}
