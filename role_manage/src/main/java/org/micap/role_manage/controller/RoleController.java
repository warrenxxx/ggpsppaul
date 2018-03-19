package org.micap.role_manage.controller;

import org.micap.role_manage.service.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * The RoleController class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
public class RoleController {
    private static final String ROLE="/role";

    @Bean
    RouterFunction<ServerResponse> Routes(RoleService roleService) {
        return nest(path(ROLE),
                route(
                        GET("/")        , Req -> roleService.getRoles(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> roleService.getRole(Req)
                ).filter((req,next)->{

                    return next.handle(req);

                })
        ).andNest(path(ROLE),
                route(
                        PUT("/")        , Req -> roleService.modifyRole(Req)
                ).andRoute(
                        DELETE("/{id}") , Req -> roleService.removerole(Req)
                )
        ).andNest(path(ROLE),
                route(
                        POST("/")       , Req -> roleService.createRole(Req)
                )
        );
    }
}
