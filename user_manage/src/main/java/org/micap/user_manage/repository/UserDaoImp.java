package org.micap.user_manage.repository;

import org.bson.types.ObjectId;
import org.micap.common.entity.Account;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_manage.dto.AccountDto;
import org.micap.user_manage.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.replaceRoot;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

/**
 * The UserDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class UserDaoImp {

    @Autowired
    public UserDao userDao;


    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    public Flux<UserDto> getUsers(){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                Aggregation.project("firstName","lastName","birthDate","gender","account")
        ),"user",UserDto.class).map(e->e.setIdToString());
    }

    public Mono<UserDto> getUser(String id){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                Aggregation.match(Criteria.where("_id").is(new ObjectId(id))),
                Aggregation.project("firstName","lastName","birthDate","gender","account")
        ),"user",UserDto.class).map(e->e.setIdToString()).publishNext();
    }
    public Flux<AccountDto> getUsersbyUsernameAndEmail(String userName, String email){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                replaceRoot("account"),
                match(Criteria.where("userName").is(userName).and("email").is(email))
        ),"user",AccountDto.class);
    }
    public Mono<User> getUser(String username, String password){

        this.userDao.findOne(Example.of(new User().setAccount(new Account().setUserName(username))))
                .filter(
                        user->true
                        //passwordEncoder.encode(password)==password
                ).map(
                user-> user
        );
        return null;
    }

    public Flux<Function> getFunctions(String id){
        return  reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                match(Criteria.where("_id").is(new ObjectId(id))),
                replaceRoot("account"),
                unwind("roles"),
                lookup("role","roles","_id","roless"),
                unwind("roless"),
                unwind("roless.functions"),
                group("null").first("functions").as("functions").push("roless.functions").as("roles"),
                project().and("roles").concatArrays("functions").as("items"),
                unwind("items"),
                replaceRoot("items")
        ),"user",Function.class);
    }
}
