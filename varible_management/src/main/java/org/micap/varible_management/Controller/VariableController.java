package org.micap.varible_management.Controller;

import org.micap.varible_management.Service.VariableService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class VariableController {

    private static final String RUTE="/variable";
    private static final String ENTITY="VARIABLE";
    @Bean
    RouterFunction<ServerResponse> Route(VariableService service) {
        return
                nest(path(RUTE),
                        route(
                                GET("/")        , service::getVariables
                        ).andRoute(
                                GET("/{id}")    , service::getVariable
                        )
  //                              .filter((req,next)->verifyFunctions(req,next,ENTITY+"-GET"))
                ).andNest(path(RUTE),
                        route(
                                PUT("/")        , service::updateVariable
                        )
//                                .filter((req,next)->verifyFunctions(req,next,auth+"-PUT"))
                ).andNest(path(RUTE),
                        route(
                                POST("/")       , service::createVariable
                        )
//                                .filter((req,next)->verifyFunctions(req,next,auth+"-PUT"))
                ).andNest(path(RUTE),
                        route(
                                DELETE("/{id}") , service::deleteVariableById
                        )
//                                .filter((req,next)->verifyFunctions(req,next,auth+"-DELETE"))
                );
    }
}
