package com.Aasha.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aasha.SpringBootDemo.dao.TaskRequest;
import com.Aasha.SpringBootDemo.model.Task;
import com.Aasha.SpringBootDemo.service.TaskService;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

	@Autowired
	TaskService service;

	
	@GetMapping("alltask")
	public ResponseEntity<?> getAllTask(){
		return ResponseEntity.ok(service.getAllTasks());
	}
	
	@GetMapping("taskById/{userid}")
	public ResponseEntity<?> getTaksByUserId(@PathVariable int userid){
		return ResponseEntity.ok(service.getAllTasksByUserId(userid));
	}
	
	@PostMapping("addtask")
	public ResponseEntity<?> addtask(@RequestBody TaskRequest task){
		return ResponseEntity.ok(service.addTask(task));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody Task task){
	    return ResponseEntity.ok(service.updateTask(id, task));
	}
	
	@GetMapping("completed/{userId}")
	public List<Task> getCompletedTasks(@PathVariable int userId) {
	    return service.getCompletedTasks(userId);
	}

	@DeleteMapping("delete/{id}")
	public String deleteTask(@PathVariable int id) {
		return service.removeTask(id);
	}

}
