package com.shouryashrey.sUrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SUrlApplication.class, args);
	}

}
