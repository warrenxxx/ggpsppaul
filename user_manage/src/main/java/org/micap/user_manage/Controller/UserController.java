package org.micap.user_manage.Controller;

import org.micap.user_manage.service.UserService;
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
public class UserController {
    private static final String RUTE="/user";
    private static final String ROLE="/role";



    @Bean
    RouterFunction<ServerResponse> Route(UserService userService) {
        return nest(path(RUTE),
                route(
                        GET("/")        , Req -> userService.getUsers(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> userService.getUser(Req)
                ).filter((req,next)->{
                        return next.handle(req);
                })
        ).andNest(path(RUTE),
                route(
                        PUT("/")        , Req -> userService.modifyUser(Req)
                ).andRoute(
                        DELETE("/{id}") , Req -> userService.removeUser(Req)
                )
        ).andNest(path(RUTE),
                route(
                        POST("/")       , Req -> userService.createUser(Req)
                )
        );
    }
    public class CustomException extends RuntimeException {

        private static final long serialVersionUID = -5970845585469454688L;

        public CustomException(String type) {
            System.out.println(type + ": throw CustomException!");
        }
    }

}

