package com.vmware.assignment.task.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.assignment.task.dao.TaskStatusRepo;
import com.vmware.assignment.task.model.Task;
import com.vmware.assignment.task.payload.TaskStatusResponse;
import com.vmware.assignment.task.property.CONSTANT;

/**
 * Responsible for querying all Task Related Table
 * @author abhinav
 *
 */

@Service
public class TaskStatusService {

	HashMap<Integer, String> hashMap;

	public TaskStatusService() {

		hashMap = new HashMap<Integer, String>();
		hashMap.put(1, CONSTANT.SUBMITTED);
		hashMap.put(2, CONSTANT.COMPLETED);
		hashMap.put(3, CONSTANT.FAILED);
		hashMap.put(4, CONSTANT.NA);
	}

	@Autowired
	private TaskStatusRepo taskStatusRepository;

	public TaskStatusResponse getTaskStatus(int id) {
		Optional<Task> findById =taskStatusRepository.findById(id);
		

		if(findById.isPresent()) {
		
		return new TaskStatusResponse( hashMap.get(findById.get().getTaskStatus()));
		
		}
		
		else {
			return new TaskStatusResponse("No Such ID Registered");
		}

	}

	public Task registerTask(String fileName) {

		return taskStatusRepository.save(new Task(fileName, 1));
	}

}
