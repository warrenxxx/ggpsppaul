package org.micap.role_management.controller;

import org.micap.role_management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.micap.common.security.Jwt.verifyFunctions;
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
@Controller
public class RoleController {
    private static final String ROLE="/role";
    private static final String AUTH="ROLE";

    @Bean
    protected RouterFunction<ServerResponse> getRoutingFunction(RoleService roleService) {
        return
        nest(path(ROLE),
                route(
                        GET("/")        , Req -> roleService.getRoles(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> roleService.getRole(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-READ"))
        ).andNest(path(ROLE),
                route(
                        PUT("/")        , Req -> roleService.modifyRole(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-PUT"))
        ).andNest(path(ROLE),
                route(
                        DELETE("/{id}") , Req -> roleService.removerole(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-DELETE"))
        ).andNest(path(ROLE),
                route(
                        POST("/")       , Req -> roleService.createRole(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-POST"))
        ).andNest(path("/entity"),
                route(
                        GET("/")       , roleService::getEntitis
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-READ"))
        );
    }
}
