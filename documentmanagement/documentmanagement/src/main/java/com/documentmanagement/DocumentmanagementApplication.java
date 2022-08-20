package com.documentmanagement;

import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocumentmanagementApplication {
	 
	public static void main(String[] args) {
		final Logger logger = LogManager.getLogger(DocumentmanagementApplication.class);
		SpringApplication.run(DocumentmanagementApplication.class, args);
		logger.info("*************Info******");
        logger.error("*************error******");
	}

}
 