package org.micap.role_manage.service;

import org.bson.types.ObjectId;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.Role;
import org.micap.role_manage.repository.RoleDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service

public class RoleService {
    @Autowired
    private RoleDaoImp roleDaoImp;

    public Mono<ServerResponse> getRoles(ServerRequest serverRequest){
        return ok().body(roleDaoImp.getRoles().map(e->new AppResponse(e,null)),AppResponse.class);
    }

    public Mono<ServerResponse> getRole(ServerRequest serverRequest){
        return roleDaoImp.getRole(serverRequest.pathVariable("id")).flatMap(
                role -> ok().contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(new AppResponse(role,null)))
                        .switchIfEmpty(
                                notFound().build()
                        )
        );
    }
    public Mono<ServerResponse> createRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class).flatMap(
                role->roleDaoImp.roleDao.existsById(role.get_id())
                    .flatMap(
                            existe->existe==true?notFound().build(): ok().body(roleDaoImp.CreateRole(role),Role.class)
                    )
        );
    }

    public Mono<ServerResponse> modifyRole(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Role.class).flatMap(
                role->roleDaoImp.roleDao.existsById(role.get_id())
                        .flatMap(
                                existe->existe==true?notFound().build(): ok().body(roleDaoImp.roleDao.save(role),Role.class)
                        )
        );
    }
    public Mono<ServerResponse> removerole(ServerRequest serverRequest){
        return roleDaoImp.roleDao.findById(serverRequest.pathVariable("id"))
                .flatMap(
                        account->ok().build(roleDaoImp.roleDao.deleteById(serverRequest.pathVariable("id")))
                )
                .switchIfEmpty(notFound().build());
    }
}
