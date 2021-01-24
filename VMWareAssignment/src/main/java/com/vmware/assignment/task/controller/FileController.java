package com.vmware.assignment.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vmware.assignment.task.model.Task;
import com.vmware.assignment.task.payload.TaskStatusResponse;
import com.vmware.assignment.task.payload.UploadFileResponse;
import com.vmware.assignment.task.service.BatchService;
import com.vmware.assignment.task.service.FileStorageService;
import com.vmware.assignment.task.service.TaskStatusService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private TaskStatusService taskStatusService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	logger.info("In Upload file");
        String fileName = fileStorageService.storeFile(file);
        
            
        Task registeredTask = taskStatusService.registerTask(new Task(fileName, 1));
        
        return new UploadFileResponse(fileName, registeredTask.getTid(),
                file.getContentType(), file.getSize());
    }
    
    @GetMapping("/getTaskStatus/{taskID}")
    public TaskStatusResponse getFile(@PathVariable int taskID) {
    	logger.info("In get file");
        return taskStatusService.getTaskStatus(taskID);
    }


    
}