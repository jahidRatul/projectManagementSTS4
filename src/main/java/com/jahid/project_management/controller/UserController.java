package com.jahid.project_management.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jahid.project_management.entity.User;
import com.jahid.project_management.repo.UserRepo;

//NOTE: Controller is API Layer. valid user can accesses this layer by calling API

@RestController		//this class will return REST API

@RequestMapping("/api")	//API URL

public class UserController {
	//Repository
	
		//@Autowired: Dependency Injection. studentRepo will be automatically instanced if not initialized
		@Autowired
		UserRepo userRepo;
		
		//in postman, hit http://localhost:8080/api/student using POST
		@PostMapping("/user")
		public ResponseEntity<User> createStudent(@RequestBody User u){
			try {
				
				User user=userRepo.save(new User(u.getId(), u.getName(), u.getEmail(),u.getPassword()));
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/user")
		public ResponseEntity<List<User>> readStudents(@RequestParam(required = false) String strSearch){
			List<User> listUsers = new ArrayList<User>();
			try {
				if(strSearch==null) {
					userRepo.findAll().forEach(listUsers::add);
				}
				else {
					userRepo.findByNameContaining(strSearch).forEach(listUsers::add);
				}
				if (listUsers.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(listUsers, HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		


}
