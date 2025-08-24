package com.Aasha.SpringBootDemo.dao;

import java.time.LocalDateTime;

import com.Aasha.SpringBootDemo.model.Task;
import com.Aasha.SpringBootDemo.model.Task.Priority;

public class TaskRequest {
    private String title;
    private String description;
    private Task.Priority priority;
    private LocalDateTime dueDate;
    private int userId; // not User object
   

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    
}
