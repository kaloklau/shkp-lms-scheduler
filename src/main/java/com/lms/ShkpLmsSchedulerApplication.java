package com.lms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.lms.scheduler.mapper")
@EnableScheduling
@ComponentScan(basePackages = "com.lms.scheduler")
public class ShkpLmsSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShkpLmsSchedulerApplication.class, args);
		
	}
}
