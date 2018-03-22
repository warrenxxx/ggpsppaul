package org.micap.login_manage;

import org.micap.login_manage.repository.LoginDaoMongoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginManageApplication {

	@Bean
	CommandLineRunner commandLineRunner(LoginDaoMongoImp userDaoMongoImp){
		return args -> {
			System.out.println(
				userDaoMongoImp.getFunctions("5ab167534779f8302c4c3971").block()
			);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(LoginManageApplication.class, args);
	}
}
