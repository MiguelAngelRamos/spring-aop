package com.kibernumacademy.aop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kibernumacademy.aop.model.User;
import com.kibernumacademy.aop.repository.UserRepository;


@Service
public class UserService {
  
  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }
  
}
