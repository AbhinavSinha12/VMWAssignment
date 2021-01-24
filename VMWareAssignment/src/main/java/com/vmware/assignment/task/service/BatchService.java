package com.vmware.assignment.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.assignment.task.job.BatchSchedulerJob;
import com.vmware.assignment.task.timer.info.TimerInfo;

@Service
public class BatchService {
	
	private SchedulerService scheduler;

	@Autowired
	public BatchService(final SchedulerService scheduler) {
		this.scheduler = scheduler;
	}
	
	public void runBatchSchedulerJob() {
		final TimerInfo info = new TimerInfo();
		info.setTotalFireCount(5);
		info.setRepeatInterval(2000);
		info.setInitialOffsetMs(100);
		info.setCallBackData("My callback Data");
		
		scheduler.schedule(BatchSchedulerJob.class, info);
	}

}
