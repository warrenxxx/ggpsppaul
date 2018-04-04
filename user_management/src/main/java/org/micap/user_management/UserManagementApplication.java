package org.micap.user_management;

import org.micap.common.config.CorsConfiguration;
import org.micap.common.entity.User;
import org.micap.common.enums.Sexo;
import org.micap.user_management.repository.UserDaoMongo;
import org.micap.user_management.repository.UserDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	public WebFilter corsFilter(){
		return CorsConfiguration.corsFilter();
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDaoMongoImp userDaoMongo){
		return args -> {
					userDaoMongo.getUser("5ac4fb72a9641d307475cc35").subscribe(System.out::println,System.out::println,System.out::println);
		};
	}
}
