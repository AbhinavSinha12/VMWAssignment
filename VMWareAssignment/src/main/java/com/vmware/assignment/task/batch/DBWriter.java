package com.vmware.assignment.task.batch;


import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmware.assignment.task.dao.UserRepo;
import com.vmware.assignment.task.model.User;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private UserRepo userRepository;

    @Autowired
    public DBWriter (UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends User> users) throws Exception{
       
        userRepository.saveAll(users);
    }
}
