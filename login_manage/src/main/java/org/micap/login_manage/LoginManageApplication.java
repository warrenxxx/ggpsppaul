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
			UserDto userDto=loginDaoImp.getUserDto(new LoginDto("warrenxxx","123456")).block();
			System.out.println(userDto==null);
			System.out.println(userDto);
			String gg=loginDaoImp.getFunctions(userDto.get_id()).block();
			System.out.println(gg);
			userDto.setToken(toJwt(userDto.get_id(),loginDaoImp.getFunctions(userDto.get_id()).block()));
//			System.out.println(
//					userDto
//			);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(LoginManageApplication.class, args);
	}
}
