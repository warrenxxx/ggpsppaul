package org.micap.jhoela;

import org.micap.jhoela.dto.HhoelDto;
import org.micap.jhoela.repository.jhoelDaoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JhoelaApplication {

	@Bean
	CommandLineRunner commandLineRunner(jhoelDaoImpl jhoelDaoimp){
		return args -> {
			jhoelDaoimp.getJhoels().collectList().block();
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(JhoelaApplication.class, args);
	}
}
