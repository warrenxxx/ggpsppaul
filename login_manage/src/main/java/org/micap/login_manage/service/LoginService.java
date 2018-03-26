package org.micap.login_manage.service;

import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.config.AppResponse;
import org.micap.login_manage.dto.LoginDto;
import org.micap.login_manage.dto.UserDto;
import org.micap.login_manage.repository.LoginDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.micap.common.security.Jwt.toJwt;
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
        UserDto user=loginDaoImp.getUserDto(serverRequest.bodyToMono(LoginDto.class).block()).defaultIfEmpty(new UserDto()).block();
        return Mono.just(user)
                .filter(userDto -> userDto.get_id()!=null)
                .map(userDto->userDto.setToken(
                                toJwt(userDto.get_id(), loginDaoImp.getFunctions(userDto.get_id()).block())
                            )
                )
                .flatMap(e->AppResponse.AppResponseOk(e))
                .switchIfEmpty(Mono.error(new UserNotFoundException()))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }
}
