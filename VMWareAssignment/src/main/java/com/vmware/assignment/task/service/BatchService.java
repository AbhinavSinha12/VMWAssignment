package com.vmware.assignment.task.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.assignment.task.job.BatchSchedulerJob;
import com.vmware.assignment.task.timer.info.TimerInfo;

@Service
public class BatchService {
	
	private static final Logger logger = LoggerFactory.getLogger(BatchService.class);
	
	private SchedulerService scheduler;

	@Autowired
	public BatchService(final SchedulerService scheduler) {
		this.scheduler = scheduler;
	}
	
	@PostConstruct
	public void runBatchSchedulerJob() {
		logger.info("Executing runBatchSchedulerJob");
		final TimerInfo info = new TimerInfo();
		info.setRunForever(true);
		info.setRepeatInterval(2000);
		info.setInitialOffsetMs(100);
		info.setCallBackData("My callback Data");
		
		scheduler.schedule(BatchSchedulerJob.class, info);
	}

}
