package org.micap.login_management;

import org.micap.common.config.CorsConfiguration;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.dto.UserDto;
import org.micap.login_management.repository.LoginDaoMongoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class LoginManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginManagementApplication.class, args);
	}
	@Bean
	public WebFilter corsFilter(){
		return CorsConfiguration.corsFilter();
	}

	@Bean
	CommandLineRunner commandLineRunner(LoginDaoMongoImp loginDaoMongoImp){
		return args -> {
			loginDaoMongoImp.getUserDto(new LoginDto("test2","123456")).defaultIfEmpty(new UserDto().setEmail("ff")).subscribe(System.out::print);
		};
	}
}
