package org.micap.microlecsson_management.controller;

import org.micap.microlecsson_management.service.MicroLessonssonService;
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
public class MicroLessonsController {
    private static final String ROLE="/microLessons";
    private static final String AUTH="MICROLESSON";

    @Bean
    protected RouterFunction<ServerResponse> getRoutingFunction(MicroLessonssonService service) {
        return
        nest(path(ROLE),
                route(
                        GET("/")        , Req -> service.getMicroLessons(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> service.getMicroLesson(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-READ"))
        ).andNest(path(ROLE),
                route(
                        PUT("/")        , Req -> service.modifyMicroLesson(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-UPDATE"))
        ).andNest(path(ROLE),
                route(
                        DELETE("/{id}") , Req -> service.removeMicroLesson(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-DELETE"))
        ).andNest(path(ROLE),
                route(
                        POST("/")       , Req -> service.createMicroLesson(Req)
                )
                        .filter((req,next)->verifyFunctions(req,next,AUTH+"-CREATE"))
        );
    }
}
