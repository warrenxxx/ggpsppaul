package org.micap.login_manage.service;

import org.micap.common.config.AppError;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.User;
import org.micap.login_manage.dto.LoginDto;
import org.micap.login_manage.dto.UserDto;
import org.micap.login_manage.repository.LoginDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * The LoginService class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */
@Service
public class LoginService {

    /**
     * Use MongoImp
     */
    @Autowired
    LoginDaoMongoImp loginDaoImp;

    public Mono<ServerResponse> login(ServerRequest serverRequest){
        return serverRequest.bodyToMono(LoginDto.class).flatMap(
                e->(e.getUserName().length()>10 && e.getPassword().length()>10)?
                        ok().build():
                        ServerResponse.status(200)
                                .body(
                                        new AppResponse(AppResponse.error(new AppError())),AppResponse.class
                                );
        );//        return ServerResponse.status(200).body(Mono.just(""),String.class);
    }
}
