package org.micap.login_manage.controller;

import org.micap.common.ExceptionHandling.BaseException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.config.AppError;
import org.micap.common.config.AppResponse;
import org.micap.login_manage.service.LoginService;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.UnknownServiceException;
import java.util.function.BiFunction;
import java.util.logging.Logger;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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
                        POST("/")        , Req -> loginService.login(Req).onErrorResume(e-> Mono.error(e))
                                        .onErrorResume( e->
                                                            badRequest()
                                                                    .body(
                                                                        Mono.just(
                                                                                new AppResponse(
                                                                                    null,
                                                                                    ((BaseException) e).appError))
                                                                        ,AppResponse.class)
                                        )
                )
        );
    }
}

