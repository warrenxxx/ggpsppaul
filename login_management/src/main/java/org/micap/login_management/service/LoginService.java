package org.micap.login_management.service;

import org.micap.common.ExceptionHandling.RequestException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.ExceptionHandling.UserWithouhtFunctionsException;
import org.micap.common.config.AppResponse;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.dto.UserLoginDto;
import org.micap.login_management.repository.LoginDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.micap.common.security.Jwt.toJwt;

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
    LoginDaoMongoImp dao;

    public Mono<ServerResponse> login(ServerRequest serverRequest){
        return     serverRequest.bodyToMono(LoginDto.class)
                .filter(e->e.getPassword()!=null&&e.getUser()!=null)
                .flatMap(
                        loginDto -> dao.getUserDto(loginDto)
                                .flatMap(
                                        userLoginDto -> dao.getFunctions(userLoginDto.get_id())
                                                .flatMap(
                                                        functions ->
                                                                AppResponse.AppResponseOk(
                                                                        userLoginDto.setToken(
                                                                                toJwt(userLoginDto.get_id(), functions)
                                                                        )
                                                                )
                                                ).switchIfEmpty(Mono.error(new UserWithouhtFunctionsException(userLoginDto.getUserName())))
                                ).switchIfEmpty(Mono.error(new UserNotFoundException()))
                )
                .switchIfEmpty(Mono.error(new RequestException()))
                .onErrorResume(e -> AppResponse.AppResponseError(e));
    }
}
