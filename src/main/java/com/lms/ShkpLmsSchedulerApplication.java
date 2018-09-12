package com.lms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lms.scheduler.mapper")
public class ShkpLmsSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShkpLmsSchedulerApplication.class, args);
	}
}
