package com.d288.d288backendprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class D288BackendProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(D288BackendProgrammingApplication.class, args);
	}

}
