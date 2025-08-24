package com.Aasha.SpringBootDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Aasha.SpringBootDemo.model.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
	@Query(value = "SELECT * FROM tasks WHERE user_id = :userId AND (status = 'in_progress' OR status = 'pending')", nativeQuery = true)
    List<Task> findByUserId(@Param("userId") int userId);
//	List<Task> findByUserId(int userId);
	@Query(value = "SELECT * FROM tasks WHERE user_id = :userId AND status = 'completed'", nativeQuery = true)
	List<Task> findCompletedTasksByUserId(@Param("userId") int userId);
}
