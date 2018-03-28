package org.micap.role_management.service;


import org.micap.common.ExceptionHandling.DuplicateIdException;
import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.Role;
import org.micap.role_management.repository.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service

public class RoleService {
    @Autowired
    private RoleDaoImp roleDaoImp;

    public Mono<ServerResponse> getRoles(ServerRequest serverRequest){
        return roleDaoImp.getRoles()
                .collectList()
                .flatMap(e-> AppResponse.AppResponseOk(e))
                    .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }

    public Mono<ServerResponse> getRole(ServerRequest serverRequest){
        return roleDaoImp.getRole(serverRequest.pathVariable("_id"))
                .flatMap(e->AppResponse.AppResponseOk(e))
                .switchIfEmpty(Mono.error(new UserNotFoundException("_id",serverRequest.pathVariable("_id"))))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }
    public Mono<ServerResponse> createRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class).flatMap(
                role->roleDaoImp.existById(role.get_id())
                    .flatMap(
                            existe->existe==true?
                                    Mono.error(new DuplicateIdException(role.get_id())):
                                    ok().body(roleDaoImp.CreateRole(role),Role.class)
                    )
                ).onErrorResume(e->AppResponse.AppResponseError(e));
    }

    public Mono<ServerResponse> modifyRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class).flatMap(
                role->roleDaoImp.roleDaoMongo.existsById(role.get_id())
                        .flatMap(
                                existe->existe==true?notFound().build(): ok().body(roleDaoImp.roleDaoMongo.save(role),Role.class)
                        )
        );
    }
    public Mono<ServerResponse> removerole(ServerRequest serverRequest){
        return roleDaoImp.roleDaoMongo.findById(serverRequest.pathVariable("id"))
                .flatMap(
                        account->ok().build(roleDaoImp.roleDaoMongo.deleteById(serverRequest.pathVariable("id")))
                )
                .switchIfEmpty(notFound().build());
    }
}
