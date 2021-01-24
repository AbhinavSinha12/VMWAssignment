package com.vmware.assignment.task.dao;

import org.springframework.data.repository.CrudRepository;

import com.vmware.assignment.task.model.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
