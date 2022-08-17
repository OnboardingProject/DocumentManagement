package com.documentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableMongoRepositories
@OpenAPIDefinition(info= @Info(title="Document Management System"))
public class DocumentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentmanagementApplication.class, args);
	}

}
