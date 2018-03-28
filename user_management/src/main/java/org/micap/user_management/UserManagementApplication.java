package org.micap.user_management;

import org.micap.common.config.CorsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
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
}
