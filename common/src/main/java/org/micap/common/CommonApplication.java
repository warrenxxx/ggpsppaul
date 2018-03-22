package org.micap.common;

import org.micap.common.config.AppResponse;
import org.micap.common.config.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommonApplication {

	@Bean
	CommandLineRunner commandLineRunner(impl impl){
		return args -> {
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(CommonApplication.class, args);

	}

}
