package com.vmware.assignment.task.payload;

public class TaskStatusResponse {
	
	 private String taskStatus;
	 
	 
	public TaskStatusResponse(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	 
	 

}
