package org.micap.login_management.controller;

import org.micap.login_management.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@Configuration
public class LoginController {
    private static final String RUTE="/login";

    @Bean
    RouterFunction<ServerResponse> Route(LoginService loginService) {
        return nest(path(RUTE),
                route(
                        POST("/")        , Req -> loginService.login(Req)
                )
        );
    }
}

