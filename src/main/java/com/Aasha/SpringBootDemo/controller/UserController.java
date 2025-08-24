package com.Aasha.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aasha.SpringBootDemo.model.User;
import com.Aasha.SpringBootDemo.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	@GetMapping("getusers")
	public ResponseEntity<?> getUsers(){
		return ResponseEntity.ok(service.getUsers());
	}
	
	@PostMapping("add")
	 public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User savedUser = service.addUsers(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	@PutMapping("update/{email}")
	public ResponseEntity<?> updatePassword(@PathVariable String email, @RequestBody User user) {
	    try {
	        User updatedUser = service.updatePassword(email, user);
	        return ResponseEntity.ok(updatedUser);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody User loginRequest) {
		 try {
		        User user = service.login(loginRequest);
		        return ResponseEntity.ok(user);
		    } catch (RuntimeException e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		    }
	    }

}
