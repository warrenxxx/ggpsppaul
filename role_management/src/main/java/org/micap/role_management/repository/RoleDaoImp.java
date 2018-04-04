package org.micap.role_management.repository;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * The RoleDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class RoleDaoImp implements RoleDao{

    @Autowired
    public RoleDaoMongo roleDaoMongo;


    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    public Flux<Role> getRoles(){
        return roleDaoMongo.findAll();
    }

    public Mono<Role> getRole(String id){
        return roleDaoMongo.findById(id);
    }

    public Mono<Role> CreateRole(Role role){
        return roleDaoMongo.save(role);
    }

    public Mono<Role> UpdataRole(Role role){
        return roleDaoMongo.save(role);
    }
    public Mono<Void> DeleteRole(Role role){
        return roleDaoMongo.delete(role);
    }
    public Mono<Void> DeleteRoleById(String id){
        return roleDaoMongo.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(String id) {
        return roleDaoMongo.existsById(id);
    }

    public Mono<dto> llamada(String id){
        return  reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                match(where("_id").is(id)),
                project("functions")
         ),"role",dto.class).publishNext();
    }

}
@Document
@Data
@ToString
class dto{
    private String _id;
    private Function functions[];
}
