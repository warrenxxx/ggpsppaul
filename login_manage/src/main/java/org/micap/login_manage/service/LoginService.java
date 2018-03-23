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
        LoginDto loginDto=serverRequest.bodyToMono(LoginDto.class).block();
        UserDto userDto=loginDaoImp.getUserDto(loginDto).block();

        if(userDto==null)
            return Mono.error(new UserNotFoundException(loginDto.getUserName(),""));
        else
            return ok().body(
                    Mono.just(
                        new AppResponse(userDto.setToken(toJwt(userDto.get_id(),loginDaoImp.getFunctions(userDto.get_id()).block())),null)
                    ),
                    AppResponse.class);
  /*
        return serverRequest.bodyToMono(LoginDto.class).flatMap(
                e->loginDaoImp.getUserDto(e.getUserName(),e.getPassword())
                        .defaultIfEmpty(new UserDto())
                        .flatMap(
                            userDto->
                                    ok().body(Mono.just(userDto.get_id()!=null?
                                    new AppResponse(
                                            userDto
//                                                    .setToken(loginDaoImp.getFunctions(userDto.get_id()).block())
                                            ,
                                            null):
                                    new AppResponse(null,
                                            new AppError[]{
                                                new AppError().setErrorCode("400").setErrorMessage("no es encontro este usuario")
                                            }
                                    )
                            ),AppResponse.class)
                        )
        );//        return ServerResponse.status(200).body(Mono.just(""),String.class);
*/
    }
}
