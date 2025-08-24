package com.Aasha.SpringBootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aasha.SpringBootDemo.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	  public User findByEmail(String email);
	

}
