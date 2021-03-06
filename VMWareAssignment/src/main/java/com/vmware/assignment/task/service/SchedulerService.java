package com.vmware.assignment.task.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmware.assignment.task.timer.info.TimerInfo;
import com.vmware.assignment.task.timer.util.TimerUtils;


@Service
public class SchedulerService {
	
	 private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
	
	private final Scheduler scheduler;
	
	@Autowired
	public SchedulerService(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	public void schedule(final Class jobClass, final TimerInfo info){
		final JobDetail jobDetail = TimerUtils.buildJobDetails(jobClass, info);
		final Trigger trigger = TimerUtils.buildTrigger(jobClass, info);
		
		try {
			scheduler.scheduleJob(jobDetail,trigger);
		}catch (SchedulerException e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
	@PostConstruct
	public void init() {
		
		try {
			scheduler.start();
		}catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	@PreDestroy
	public void preDestroy() {
		try {
			scheduler.shutdown();
		}catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	

}
