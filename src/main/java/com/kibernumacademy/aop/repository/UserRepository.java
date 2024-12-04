package com.kibernumacademy.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kibernumacademy.aop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
