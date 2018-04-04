package org.micap.varible_management.Service;

import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.config.AppResponse;
import org.micap.common.entity.Variable;
import org.micap.varible_management.repository.VariableDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class VariableService {
    @Autowired
    private VariableDaoImpl variableDao;

    public Mono<ServerResponse> getVariable(ServerRequest request){
        return variableDao
                .getVariable(request.pathVariable("id") )
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
    public Mono<ServerResponse> getVariables(ServerRequest request){
        return variableDao
                .getVariables()
                .collectList()
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }

    public Mono<ServerResponse> createVariable(ServerRequest req){
        return variableDao
                .createVariable(req.bodyToMono(Variable.class).block())
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
    public Mono<ServerResponse> updateVariable(ServerRequest req){
        return variableDao
                .updateVariable(req.bodyToMono(Variable.class).block())
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
    public Mono<ServerResponse> deleteVariable(ServerRequest req){
        return variableDao
                .deleteVariable(req.bodyToMono(Variable.class).block())
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
    public Mono<ServerResponse> deleteVariableById(ServerRequest req){
        return variableDao
                .deleteVariable(req.bodyToMono(Variable.class).block())
                .flatMap(e-> AppResponse.AppResponseOk(e))
                .onErrorResume(e->AppResponse.AppResponseError(new SystemException(e)));
    }
}
