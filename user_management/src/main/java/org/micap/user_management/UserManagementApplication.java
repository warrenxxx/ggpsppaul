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
	public CommandLineRunner commandLineRunner(UserDaoMongo userDaoMongo){
		return args -> {
//		    userDaoMongo.insert(new User().setBirthDate(LocalDate.now()).setGender(Sexo.MASCULINO)).subscribe(System.out::print);
		};
	}
}
