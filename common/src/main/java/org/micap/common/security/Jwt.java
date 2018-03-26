package org.micap.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.micap.common.ExceptionHandling.AuthorizationException;
import org.micap.common.ExceptionHandling.BaseException;
import org.micap.common.ExceptionHandling.HeaderException;
import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.config.AppResponse;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * The Jwt class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */
public class Jwt {

    private static final String  Function="functions";
    public static String toJwt(String _id,String functions){
        functions=functions==null?"":functions;
        try {
            return JWT.create()
                    .withIssuer("auth0")
                    .withHeader(Map.of(
                        "_id",_id,
                        Function,functions
                    ))

                    .sign(Algorithm.HMAC256("SECRETO"));
        } catch (Exception exception){
            return "";
        }
    }


    public static Mono<ServerResponse> verifyFunctions(ServerRequest req, HandlerFunction<ServerResponse> next, String function) {
            return Flux.just(req.headers().header("Authorization").toArray(new String[0]))
                    .limitRequest(1)
                    .map(e-> JWT.decode(e))
                    .flatMap(e->e.getHeaderClaim(Function).asString().contains(function)?
                                    next.handle(req):
                                    Mono.error(new AuthorizationException("_id",e.getHeaderClaim("_id").asString())))
                    .publishNext()
                    .switchIfEmpty(Mono.error(new HeaderException("Authorization")))
//                    .onErrorResume(e->badRequest().body(Mono.just(new AppResponse(e)),AppResponse.class))
                    .onErrorResume(e->AppResponse.AppResponseError(e))
                    ;


/*
            if(l.size()!=1)
                return Mono.error(new HeaderException("Authorization"));
            DecodedJWT jwt = JWT.decode(l.get(0));
            return jwt.getHeaderClaim(Function).asString().contains(function) ?
                        next.handle(req):
                        Mono.error(new AuthorizationException("id",jwt.getHeaderClaim("_id").asString()));
*/
    }

}
