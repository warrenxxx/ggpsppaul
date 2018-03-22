package org.micap.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

/**
 * The impl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :21/03/2018
 */
@Service
public class impl {
    @Autowired
    gg gg;

    public void ff(){
        gg.insert(new guffy("wau wau")).subscribe(System.out::println);
    }
}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class guffy{
    private String firulaiz;
}
interface gg extends ReactiveMongoRepository<guffy,String> {}
class warrenException extends base{

    public warrenException(String []gg,Object object){
        super(warrenException.class.getSimpleName(),object,new String[]{"w"});
    }
    @Autowired
    gg gg;
    public void insertarUnGuffy(){
        gg.insert(new guffy("wau wau")).subscribe(System.out::println);
    }
}
