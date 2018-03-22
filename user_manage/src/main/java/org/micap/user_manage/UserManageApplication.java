package org.micap.user_manage;

import org.micap.common.config.AppResponse;
import org.micap.common.config.impl;
import org.micap.user_manage.repository.UserDao;
import org.micap.user_manage.repository.UserDaoMongo;
import org.micap.user_manage.repository.UserDaoMongoImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.NettyContext;
import reactor.ipc.netty.http.server.HttpServer;


@SpringBootApplication
public class UserManageApplication {

	@Bean
	CommandLineRunner commandLineRunner(UserDaoMongo userDao){
		return args -> {
			userDao.findByLastName(Mono.just("aroni")).subscribe(System.out::println);
			new impl().ff();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run( UserManageApplication.class, args);

	}


}

