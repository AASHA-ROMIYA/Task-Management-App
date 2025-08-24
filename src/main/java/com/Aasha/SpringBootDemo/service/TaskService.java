package com.Aasha.SpringBootDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Aasha.SpringBootDemo.dao.TaskDao;
import com.Aasha.SpringBootDemo.dao.TaskRequest;
import com.Aasha.SpringBootDemo.dao.UserDao;
import com.Aasha.SpringBootDemo.model.Task;
import com.Aasha.SpringBootDemo.model.User;

@Service
public class TaskService {
	
	@Autowired
	TaskDao taskdao;
	@Autowired
	UserDao userdao;
	
	public List<Task> getAllTasks(){
		return taskdao.findAll();
	}
	
	public List<Task> getAllTasksByUserId(int userid){
		return taskdao.findByUserId(userid);
	}
	
	public Task addTask(TaskRequest taskRequest) {
        User user = userdao.findById(taskRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        task.setDueDate(taskRequest.getDueDate());
        task.setUser(user); // ✅ set actual User entity

        return taskdao.save(task); // ✅ just save and return
    }
	
	public List<Task> getCompletedTasks(int userId) {
	    return taskdao.findCompletedTasksByUserId(userId);
	}
	
	public Task updateTask(int id, Task task) {
	    Task oldtask = taskdao.findById(id).orElse(null);

	    if (oldtask == null) {
	        throw new RuntimeException("Task not found!");
	    }

	    oldtask.setPriority(task.getPriority());
	    oldtask.setStatus(task.getStatus());
	    oldtask.setUpdatedAt(LocalDateTime.now());

	    return taskdao.save(oldtask);
	}

	public String removeTask(int id) {
		Task oldtask = taskdao.findById(id).orElse(null);
		if(oldtask!=null) {
			taskdao.deleteById(id);
			return "deleted !!";
		}
		else {
			new RuntimeException("Task not found!");
		}
		return "not found task";
		
	}

}
