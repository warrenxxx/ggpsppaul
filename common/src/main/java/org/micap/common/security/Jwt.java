package org.micap.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.micap.common.entity.Function;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

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
            System.out.println(_id);
            return JWT.create()
                    .withIssuer("auth0")
                    .withHeader(Map.of(
                        "_id",_id,
                        Function,functions
                    ))
                    .sign(Algorithm.HMAC256("SECRETO"));
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
            return "";
        } catch (JWTCreationException exception){
            return "";
            //Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    public static Mono<ServerResponse> verifyFunctions(ServerRequest req, HandlerFunction<ServerResponse> next, String function){
        try {
            List<String> l=req.headers().header("Authorization");
            if(l.size()!=1)
                return ServerResponse.status(UNAUTHORIZED).build();


            DecodedJWT jwt = JWT.decode(l.get(0));
            System.out.println(jwt.getHeaderClaim(Function).asString()+"-->>>"+function);
            return jwt.getHeaderClaim(Function).asString().indexOf(function)!=-1?
                    next.handle(req):
                    ServerResponse.status(UNAUTHORIZED).build();
        } catch (JWTDecodeException exception){
            return ServerResponse.status(UNAUTHORIZED).build();
        }
    }
}
