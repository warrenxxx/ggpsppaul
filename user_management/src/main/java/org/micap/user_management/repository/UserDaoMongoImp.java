package org.micap.user_management.repository;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.micap.common.entity.Account;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_management.dto.AccountDto;
import org.micap.user_management.dto.AllUserDto;
import org.micap.user_management.dto.UserDto;
import org.micap.user_management.dto.UserWithoutPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import static java.lang.Math.floor;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * The UserDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class UserDaoMongoImp implements UserDao {


    @Autowired
    public UserDaoMongo userDaoMongo;

    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    @Override
    public Flux<AllUserDto> getUsers(){
        ArithmeticOperators.Divide updated = ArithmeticOperators.Divide.valueOf(aggregationOperationContext -> new Document("$subtract", Arrays.asList(new Date(), "$birthDate"))).divideBy(365 * 24*60*60*1000/0.04);
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                Aggregation.project("_id","firstName","lastName","gender")
                        .and("account.roles").size().as("roleCount")
                        .and("account.email").as("email")
                        .and("account.userName").as("userName")
                        .and(updated).as("age")
        ),"user",AllUserDto.class).map(e->e.setAge( floor((Double) e.getAge())));
    }

    @Override
    public Mono<UserWithoutPasswordDto> getUser(String id){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                Aggregation.match(Criteria.where("_id").is(new ObjectId(id)))
//                , project("_id","").and("account.roles").size().as("roleCount")
        ),"user",UserWithoutPasswordDto.class).publishNext();
    }

    @Override
    public Flux<AccountDto> getUsersbyUsername(String userName){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                replaceRoot("account"),
                match(Criteria.where("userName").is(userName))
        ),"user",AccountDto.class);
    }

    @Override
    public Mono<User> getUser(String username, String password){
        this.userDaoMongo.findOne(Example.of(new User().setAccount(new Account().setUserName(username))))
                .filter(
                        user->true
                        //passwordEncoder.encode(password)==password
                ).map(
                user-> user
        );
        return null;
    }

    @Override
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

    @Override
    public Mono<UserDto> createUser(User user) {
        return this.userDaoMongo.insert(user)
                .map(e->new UserDto());
    }

    @Override
    public Mono<UserDto> updateUser(User user) {
        return this.userDaoMongo.save(user)
                .map(e->new UserDto());
    }


    @Override
    public Mono<Void> deleteUser(User user) {
        return this.userDaoMongo.delete(user);
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return this.userDaoMongo.deleteById(id);
    }

    @Override
    public Mono<Boolean> existById(String id) {
        return this.userDaoMongo.existsById(id);
    }

}
