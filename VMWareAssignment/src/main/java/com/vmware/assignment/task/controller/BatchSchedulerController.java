package com.vmware.assignment.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.assignment.task.service.BatchService;

@RestController
@RequestMapping("/api/timer") 
public class BatchSchedulerController {

	
	private BatchService batchService;
	
	@Autowired
	public BatchSchedulerController(BatchService batchService) {
		this.batchService = batchService;
	}
	
	@PostMapping("/runbatchprocessor")
	public void runbatchProcessorJob() {
		batchService.runBatchSchedulerJob();
	}
}
