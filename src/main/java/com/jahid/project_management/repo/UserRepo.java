package com.jahid.project_management.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jahid.project_management.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	List<User> findByNameContaining(String name);
}