package com.vmware.assignment.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private int tid;
	private String taskName;
	private int taskStatus;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param tid
	 * @param taskName
	 * @param taskStatus
	 */
	public Task(String taskName, int taskStatus) {
		this.taskName = taskName;
		this.taskStatus = taskStatus;
	}
	
	/**
	 * @param tid
	 * @param taskName
	 * @param taskStatus
	 */
	public Task(int tid, String taskName, int taskStatus) {
		this.tid = tid;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	 
	
	

}
