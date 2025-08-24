package com.Aasha.SpringBootDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Aasha.SpringBootDemo.dao.UserDao;
import com.Aasha.SpringBootDemo.model.User;

@Service
public class UserService {
	@Autowired
	UserDao userdao;

	public User addUsers(User user) {
        if(userdao.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists!");
        }
        return userdao.save(user);
    }
	
	public User updatePassword(String email, User u) {
	    User user = userdao.findByEmail(email);
	    if (user != null) {
	        user.setPassword(u.getPassword());
	        user.setUpdatedAt(LocalDateTime.now());
	        return userdao.save(user);
	    } else {
	        throw new RuntimeException("Email does not exist!");
	    }
	}
	
	public User login(User user) {
		User user1 = userdao.findByEmail(user.getEmail());
		if (user1 != null && user1.getPassword().equals(user.getPassword())) {
            return user1; // ✅ Return full user with role
        } 
		else if(user1!=null && !user1.getPassword().equals(user.getPassword()) ) {
			throw new RuntimeException("wrong password!");
		}
		else {
	        throw new RuntimeException("Email does not exist!");
	    }
	}
	
	public List<User> getUsers(){
		List<User> users = userdao.findAll();
		return users;
	}
	
	

}
