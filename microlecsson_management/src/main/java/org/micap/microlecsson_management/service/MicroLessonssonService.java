package org.micap.microlecsson_management.service;


import org.bson.types.ObjectId;
import org.micap.common.ExceptionHandling.DuplicateIdException;
import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.MicroLesson;
import org.micap.common.security.Jwt;
import org.micap.microlecsson_management.repository.MicroLessonDao;
import org.micap.microlecsson_management.repository.MicroLessonDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service

public class MicroLessonssonService {
    @Autowired
    private MicroLessonDao dao;

    public MicroLessonssonService(MicroLessonDaoImp microLessonDaoImp) {
        this.dao=microLessonDaoImp;
    }

    public Mono<ServerResponse> getMicroLessons(ServerRequest serverRequest){
        return dao.getMicroLessons()
                .collectList()
                .flatMap(e-> AppResponse.AppResponseOk(e))
                    .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }

    public Mono<ServerResponse> getMicroLesson(ServerRequest serverRequest){
        return dao.getMicroLesson(serverRequest.pathVariable("id"))
                .flatMap(e->AppResponse.AppResponseOk(e))
                .switchIfEmpty(Mono.error(new UserNotFoundException("id",serverRequest.pathVariable("id"))))
                .onErrorResume(e->AppResponse.AppResponseError(e));
    }
    public Mono<ServerResponse> createMicroLesson(ServerRequest serverRequest){
        return serverRequest.bodyToMono(MicroLesson.class)
                .flatMap(
                            microLesson->
                                    Jwt.getIdOfJwtToken(serverRequest).flatMap(
                                            jwt->ok().body(dao.CreateMicroLesson(
                                                    microLesson
                                                            .set_id(new ObjectId().toString())
                                                            .setIdUser(jwt)
                                            ),MicroLesson.class)
                                    )
                ).onErrorResume(e->AppResponse.AppResponseError(e));
    }

    public Mono<ServerResponse> modifyMicroLesson(ServerRequest serverRequest){
        return serverRequest.bodyToMono(MicroLesson.class).flatMap(
                MicroLesson->dao.existById((MicroLesson.get_id()))
                        .flatMap(
                                existe->existe==true?notFound().build(): ok().body(dao.UpdataMicroLesson(MicroLesson),MicroLesson.class)
                        )
        );
    }
    public Mono<ServerResponse> removeMicroLesson(ServerRequest serverRequest){
        return dao.getMicroLesson(serverRequest.pathVariable("id"))
                .flatMap(
                        account->ok().build(dao.DeleteMicroLessonById(serverRequest.pathVariable("id")))
                )
                .switchIfEmpty(notFound().build());
    }
}
