package com.vmware.assignment.task.job;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmware.assignment.task.dao.TaskStatusRepo;
import com.vmware.assignment.task.exception.JobExecutionException;
import com.vmware.assignment.task.model.Task;
import com.vmware.assignment.task.property.FileStoragePropConfiguration;
import com.vmware.assignment.task.service.FileStorageService;

@Component
public class BatchSchedulerJob implements Job {
	
	@Autowired
	private TaskStatusRepo taskStatusRepo;

	private static final Logger logger = LoggerFactory.getLogger(BatchSchedulerJob.class);
	
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	FileStoragePropConfiguration fileStorageProperties;

	@Autowired
	org.springframework.batch.core.Job job;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Scheduler executing");
		
		List<Task> taskStatusList = taskStatusRepo.findByTaskStatus(1); 

		Map<String, JobParameter> maps = new HashMap<>();
		
		
		for(Task task:taskStatusList) {
			
			try {
		   String path = fileStorageProperties.getUploadDir()+File.separator+task.getTaskName();
			maps.put("time", new JobParameter(System.currentTimeMillis()));
			maps.put("fullPathFileName",
					new JobParameter(path));
			JobParameters parameters = new JobParameters(maps);
			JobExecution jobExecution;
			
				jobExecution = jobLauncher.run(job, parameters);
				System.out.println("JobExecution: " + jobExecution.getStatus());
				
				if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
					task.setTaskStatus(2);
					taskStatusRepo.save(task);
				}
				else if(jobExecution.getStatus() == BatchStatus.FAILED) {
					task.setTaskStatus(3);
					taskStatusRepo.save(task);
				}

				
			} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
					| JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
		}
		

	}

}
