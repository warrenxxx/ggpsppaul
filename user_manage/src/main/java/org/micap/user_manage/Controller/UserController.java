package org.micap.user_manage.Controller;

import org.micap.user_manage.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static org.micap.common.security.Jwt.verifyFunctions;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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

    private static final String auth="USER";

    @Bean
    RouterFunction<ServerResponse> Route(UserService userService) {
        return nest(path(RUTE),
                route(
                        GET("/")        , Req -> userService.getUsers(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> userService.getUser(Req)
                ).filter((req,next)->verifyFunctions(req,next,auth+"-GET"))
        ).andNest(path(RUTE),
                route(
                        PUT("/")        , Req -> userService.modifyUser(Req)
                ).filter((req,next)->verifyFunctions(req,next,auth+"-PUT"))
        ).andNest(path(RUTE),
                route(
                        POST("/")       , Req -> userService.createUser(Req)
                )
        ).andNest(path(RUTE),
                route(
                        DELETE("/{id}") , Req -> userService.removeUser(Req)
                ).filter((req,next)->verifyFunctions(req,next,auth+"-DELETE"))
        );
    }
}

