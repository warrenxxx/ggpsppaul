package org.micap.role_management.service;


import org.bson.types.ObjectId;
import org.micap.common.ExceptionHandling.*;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.micap.role_management.repository.RoleDao;
import org.micap.role_management.repository.RoleDaoImp;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.xml.bind.SchemaOutputResolver;
import java.util.stream.Stream;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service

public class RoleService {

    private RoleDao roleDaoImp;

    public RoleService(RoleDaoImp roleDaoImp) {
        this.roleDaoImp = roleDaoImp;
    }

    public Mono<ServerResponse> getRoles(ServerRequest serverRequest){
        return roleDaoImp.getRoles()
                .collectList()
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
    public Mono<ServerResponse> getEntitis(ServerRequest serverRequest){
        return roleDaoImp.getEntitis()
                .map(e->e.toUpperCase())
                .collectList()
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));

    }


    public Mono<ServerResponse> getRole(ServerRequest serverRequest){
        return roleDaoImp.getRole(serverRequest.pathVariable("id"))
                .flatMap(e->AppResponse.AppResponseOk(e))
                .switchIfEmpty(Mono.error(new UserNotFoundException("id",serverRequest.pathVariable("id"))))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }
    public Mono<ServerResponse> createRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class)
                .map(e->e.set_id(new ObjectId().toString()))
                .flatMap(
                    role->roleDaoImp.existById(role.get_id())
                    .flatMap(
                            existe->existe==true?
                                    Mono.error(new DuplicateIdException(role.get_id())):
                                    AppResponse.AppResponseOk()
                    )
                ).onErrorResume(e->AppResponse.AppResponseError(e));
    }

    public Mono<ServerResponse> modifyRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class).flatMap(
                role->roleDaoImp.UpdataRole(role).flatMap(
                        roleUpdate->AppResponse.AppResponseOk()
                )
        ).onErrorResume(e->AppResponse.AppResponseError(e));
    }
    public Mono<ServerResponse> removerole(ServerRequest serverRequest){
        return roleDaoImp.getRole(serverRequest.pathVariable("id"))
                .flatMap(
                        role->roleDaoImp.DeleteRoleById(serverRequest.pathVariable("id")).flatMap(
                                roleDelete->AppResponse.AppResponseOk()
                        ).switchIfEmpty(Mono.error(new ObjetcNotFoundException()))
                )
                .switchIfEmpty(Mono.error(new RequestException()))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }

}
