package com.vmware.assignment.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vmware.assignment.task.dao.TaskStatusRepo;
import com.vmware.assignment.task.model.Task;
import com.vmware.assignment.task.property.CONSTANT;
import com.vmware.assignment.task.service.TaskStatusService;

@SpringBootTest
class VmWareAssignmentApplicationTests {
	


	@Autowired
	private TaskStatusService taskStatusService;
	
	@MockBean
	private TaskStatusRepo taskStatusRepo;
	
	@Test
	public void getTaskStatusTest() {
		when(taskStatusRepo.findById(1)).thenReturn(Optional.of(new Task(1,"text.txt", 1)));
		assertEquals(CONSTANT.SUBMITTED,taskStatusService.getTaskStatus(1).getTaskStatus());
	}

	
	@Test
	public void registerTask() {
		
		Task task = new Task(123,"text.file", 1);
		when(taskStatusRepo.save(task)).thenReturn(task);
		assertEquals(123,taskStatusService.registerTask(task).getTid());
	}
	
	 
	
	@Test
	void contextLoads() {
		 
	}
	
	


}
