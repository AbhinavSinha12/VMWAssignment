package com.vmware.assignment.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.vmware.assignment.task.property.FileStoragePropConfiguration;


@EnableConfigurationProperties({
        FileStoragePropConfiguration.class
})


@SpringBootApplication
public class VmWareAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmWareAssignmentApplication.class, args);
	}

}
