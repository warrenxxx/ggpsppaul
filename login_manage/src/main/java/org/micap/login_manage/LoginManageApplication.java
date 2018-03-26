package org.micap.login_manage;

import org.micap.login_manage.dto.LoginDto;
import org.micap.login_manage.dto.UserDto;
import org.micap.login_manage.repository.LoginDaoMongoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.micap.common.security.Jwt.toJwt;

@SpringBootApplication
public class LoginManageApplication {

	@Bean
	CommandLineRunner commandLineRunner(LoginDaoMongoImp loginDaoImp){
		return args -> {
			};
	}
	public static void main(String[] args) {
		SpringApplication.run(LoginManageApplication.class, args);
	}
}
