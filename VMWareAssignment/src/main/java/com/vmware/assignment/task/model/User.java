package com.vmware.assignment.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer uid;
	private String username;
	private Integer age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param uid
	 * @param userName
	 * @param age
	 */
	public User(int uid, String userName, int age) {
		this.uid = uid;
		this.username = userName;
		this.age = age;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	

}
