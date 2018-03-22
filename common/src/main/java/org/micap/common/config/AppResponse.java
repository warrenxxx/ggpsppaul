package org.micap.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.micap.common.ExceptionHandling.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The response class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@AllArgsConstructor
public class AppResponse {
    public Object data;
    public AppError errors[];



    public static Mono<AppResponse> error(AppError appErrors[]){
        return Mono.just(new AppResponse(null,appErrors));
    }

    public static Mono<AppResponse> accept(Object data){
        return Mono.just(new AppResponse(data,null));
    }

    public static String showMsg(String msg) throws warrenException {
        //Create message anyways and return it
        throw new warrenException(new String[]{},"");

    }



    public static void  main(String args[]) throws UserNotFoundException{
        throw new  UserNotFoundException("id","12331");
    }
}

class base extends Exception{

    public Object object;
    public base() {
        super();
    }

    public base(String name,String params[]){
        super(aggtmreps(name,name));
        this.object=null;
    }
    public base(String name,Object object,String params[]){
        super(aggtmreps(name,name));
        this.object=object;
    }
    public static String aggtmreps(String name,String otro){
        return name+"_____"+otro;
    }
}