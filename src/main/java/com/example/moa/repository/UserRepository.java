package com.example.moa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moa.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	User findByUsername(String username);
}
