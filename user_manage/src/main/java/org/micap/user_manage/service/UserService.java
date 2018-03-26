package org.micap.user_manage.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_manage.repository.UserDaoMongoImp;
import org.micap.common.config.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
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
        return
                ok().body(
                        userDaoImp.getUsers()
//                                .map(e->new AppResponse(e,null))
                                .map(e->new AppResponse(e))
                        ,AppResponse.class
                );
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest){
        return userDaoImp.getUser(serverRequest.pathVariable("id")).flatMap(
                userDto -> ok().contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(new AppResponse(userDto)))
                        .switchIfEmpty(
                                Mono.error(new InvalidParameterException())
                        )
        );
    }
    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
        return serverRequest.bodyToMono(User.class).
        flatMap(
                e-> userDaoImp.getUsersbyUsernameAndEmail(e.getAccount().getUserName(),e.getAccount().getEmail())
                        .count().block()==0?
                            userDaoImp.createUser(
                                            e.set_id(new ObjectId().toString())
                                            .newAudit()
                                            .setAccount(
                                                    e.getAccount()
                                                    .setRoles(new String[]{"USER"})
                                                    .setFunctions(new Function[]{})
                                            )
                                    ).flatMap(x->ok().build()):
                            notFound().build()
        );
    }

    public Mono<ServerResponse> modifyUser(ServerRequest serverRequest){
        return  userDaoImp.createUser(
                serverRequest.bodyToMono(User.class)
                        .block()
                        .newAudit()
        )
                .flatMap(User->ok().build())
                .switchIfEmpty(notFound().build());
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

