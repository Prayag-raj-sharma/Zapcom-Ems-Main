package com.ems.ems.project;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ems.ems.project.controller.EmployeeController;

@SpringBootApplication
public class EmsProjectApplication {
	
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(EmsProjectApplication.class);
		
		 logger.info("this is a info message");
	     logger.warn("this is a warn message");
	     logger.error("this is a error message");
		SpringApplication.run(EmsProjectApplication.class, args);
	}

}
