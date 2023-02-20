package com.springangular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springangular.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
