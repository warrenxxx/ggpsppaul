package org.micap.role_management;

import org.micap.common.config.CorsConfiguration;
import org.micap.common.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;

@SpringBootApplication
public class RoleManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoleManagementApplication.class, args);
    }

    @Bean
    public WebFilter corsFilter() {
        return CorsConfiguration.corsFilter();
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return  args -> {
            Role administrador=new Role();
        };
    }
}
