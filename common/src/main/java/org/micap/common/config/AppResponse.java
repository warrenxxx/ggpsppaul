package org.micap.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.micap.common.ExceptionHandling.BaseException;
import org.micap.common.ExceptionHandling.SystemException;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * The response class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */

public class AppResponse {
    public Object data;
    public AppError error;

    public AppResponse(Object data, Throwable error) {
        if(data==null){
            if(error instanceof BaseException)
                this.error=((BaseException)error).appError;
            else
                this.error=new SystemException("System","error",error.getMessage()).appError;
        }else {
            this.data=data;
        }
    }
/*
    public AppResponse(Object data)
    {
        this.data = data;
    }

    public AppResponse(Throwable e){
        if(e instanceof BaseException)
            this.error=((BaseException)e).appError;
        else
            this.error=new SystemException("System","error",e.getMessage()).appError;
    }
*/
    public static Mono<ServerResponse> AppResponseError(Throwable t){
        return badRequest()
                .body(
                        Mono.just(
                                new AppResponse(null,t)
                        )
                        ,AppResponse.class
                );
    }
    public static Mono<ServerResponse> AppResponseOk(Object responseObject){
        return ok()
                .body(
                        Mono.just(new AppResponse(responseObject,null))
                        ,AppResponse.class
                );
    }
    public static Mono<ServerResponse> AppResponseOkMono(Mono object){
        return ok()
                .body(
                        object.map(e->new AppResponse(e,null))
                        ,AppResponse.class
                );
    }
    public static Mono<ServerResponse> AppResponseOk(){
        return ok()
                .body(
                        Mono.just(new AppResponse(Map.of("message","successful operation"),null))
                        ,AppResponse.class
                );
    }
}
