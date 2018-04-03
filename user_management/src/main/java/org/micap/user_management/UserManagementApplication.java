package org.micap.user_management;

import org.micap.common.config.CorsConfiguration;
import org.micap.user_management.repository.UserDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	public WebFilter corsFilter(){
		return CorsConfiguration.corsFilter();
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDaoMongoImp userDaoMongoImp){
		return args -> {
			System.out.println(userDaoMongoImp.getUsers().collectList().block());
		};
	}
}
