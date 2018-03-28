package org.micap.user_management.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.micap.common.ExceptionHandling.DuplicateIdException;
import org.micap.common.ExceptionHandling.DuplicateUserNameException;
import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_management.dto.UserDto;
import org.micap.user_management.repository.UserDaoMongoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.micap.common.security.Jwt.getIdOfJwtToken;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserDaoMongoImp userDaoImp;

    public Mono<ServerResponse> getUsers(ServerRequest serverRequest){
        return userDaoImp.getUsers()
                .collectList().flatMap(e->AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest){
        return userDaoImp.getUser(serverRequest.pathVariable("_id"))
                .flatMap(e->AppResponse.AppResponseOk(e))
                .switchIfEmpty(Mono.error(new UserNotFoundException("_id",serverRequest.pathVariable("_id"))))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }

    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
        return serverRequest.bodyToMono(User.class).flatMap(
                user->userDaoImp.getUsersbyUsername(user.getAccount().getUserName())
                        .count()
                        .flatMap(
                                size -> size>0?
                                        Mono.error(new DuplicateUserNameException(user.getAccount().getUserName())):
                                        AppResponse.AppResponseOkMono(userDaoImp.createUser(
                                                user.newAudit()
                                                .setAccount(
                                                        user.getAccount()
                                                        .setRoles(new String[]{"USER"})
                                                        .setFunctions(new Function[]{})
                                                )
                                        ).map(e->"registered user"))
                        )
        ).onErrorResume(e->AppResponse.AppResponseError(e));
    }

    public Mono<ServerResponse> modifyUser(ServerRequest serverRequest){
        return serverRequest.bodyToMono(User.class).flatMap(
                user->userDaoImp.getUsersbyUsername(user.getAccount().getUserName())
                        .count()
                        .flatMap(
                                size -> size>0?
                                        Mono.error(new DuplicateUserNameException(user.getAccount().getUserName())):
                                        getIdOfJwtToken(serverRequest).flatMap(
                                                id->AppResponse.AppResponseOkMono(
                                                        userDaoImp.updateUser(
                                                                user
                                                                .updateAudit(id)
                                                                .setAccount(
                                                                        user.getAccount()
                                                                                .setRoles(new String[]{"USER"})
                                                                                .setFunctions(new Function[]{})
                                                                )
                                                        )
                                                )
                                        )
                        )
        ).onErrorResume(e->AppResponse.AppResponseError(e));
    }
    public Mono<ServerResponse> removeUser(ServerRequest serverRequest){
        return userDaoImp.getUser(serverRequest.pathVariable("id"))
                .flatMap(
                        account->
                                ok().build(userDaoImp.deleteUser(serverRequest.pathVariable("id")))
                )
                .switchIfEmpty(notFound().build());
    }
}
