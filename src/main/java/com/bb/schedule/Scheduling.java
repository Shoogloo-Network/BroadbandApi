package com.bb.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.bb.service.AdminService;

@Configuration
@EnableScheduling
public class Scheduling {
	@Autowired AdminService   adminService;
	
	@Scheduled(fixedRate = 43200*1000)
	public void scheduleFixedDelayTask() {
	    System.out.println(
	      "Fixed delay task - " +new Date());
	  
//	adminService.cacheBoradBandObjects();
	    
	}
}
