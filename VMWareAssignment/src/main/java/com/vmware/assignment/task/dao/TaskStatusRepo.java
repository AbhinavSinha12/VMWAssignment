package com.vmware.assignment.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmware.assignment.task.model.Task;

@Repository
public interface TaskStatusRepo extends JpaRepository<Task, Integer> {
	
	List<Task> findByTaskStatus(int taskStatus);
	
}