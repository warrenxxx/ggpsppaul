package org.micap.user_management.repository;

import com.mongodb.BasicDBObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.micap.common.entity.Account;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_management.dto.*;
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
        ArithmeticOperators.Divide updated = ArithmeticOperators.Divide.valueOf(aggregationOperationContext -> new Document("$subtract", Arrays.asList(new Date(), "$birthDate"))).divideBy(365 * 24*60*60*1000/0.04666);

        System.out.println(
                Aggregation.newAggregation(
                        Aggregation.project()
                                .and("account.roles").size().as("roleCount")
                                .and("account.email").as("email")
                                .and("account.userName").as("userName")
                                .and(updated).as("age")

                                .and("_id").as("user._id")
                                .and("firstName").as("user.firstName")
                                .and("lastName").as("user.lastName")
                                .and("gender").as("user.gender")
                                .and("birthDate").as("user.birthDate")
                ).toString()

        );
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                Aggregation.project()
                        .and("account.roles").size().as("roleCount")
                        .and("account.email").as("email")
                        .and("account.userName").as("userName")
                        .and(updated).as("age")

                        .and("_id").as("user._id")
                        .and("firstName").as("user.firstName")
                        .and("lastName").as("user.lastName")
                        .and("gender").as("user.gender")
                        .and("birthDate").as("user.birthDate")
        ),"user",AllUserDto.class).map(
                e->e.setAge( floor((Double) e.getAge()))
        );
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
    @Override
    public Mono<UserWithoutPasswordDto> getUser(String id){
        ArithmeticOperators.Divide updated = ArithmeticOperators.Divide.valueOf(aggregationOperationContext -> new Document("$subtract", Arrays.asList(new Date(), "$birthDate"))).divideBy(365 * 24*60*60*1000/0.04666);

        reactiveMongoOperations.aggregate(
                Aggregation.newAggregation(
                        Aggregation.match(Criteria.where("_id").is(new ObjectId(id))),
                        unwind("account.roles"),
                        lookup("role","account.roles","_id","account.roles"),
                        unwind("account.roles"),
                        group( "_id")
                                .first("firstName").as("firstName")
                                .first("lastName").as("lastName")
                                .first("birthDate").as("birthDate")
                                .first("gender").as("gender")
                                .first("account").as("account")
                                .push("account.roles").as("roles"),

                        project("_id","firstName","lastName","birthDate","gender","account.email","account.userName","account.functions")
                                .and(updated).as("age")
                                .and("roles").as("account.roles")
                                .and("account.email").as("account.email")
                                .and("account.userName").as("account.userName")
                                .and("account.functions").as("account.functions")
                ),"user",UserWithoutPasswordDto.class).map(e->e.setAge( floor((Double) e.getAge()))).publishNext().subscribe(System.out::print);

        System.out.println(
                Aggregation.newAggregation(
                        Aggregation.match(Criteria.where("_id").is(new ObjectId(id))),
                        unwind("account.roles"),
                        lookup("role","account.roles","_id","account.roles"),
                        unwind("account.roles"),
                        group( "_id")
                                .first("firstName").as("firstName")
                                .first("lastName").as("lastName")
                                .first("birthDate").as("birthDate")
                                .first("gender").as("gender")
                                .first("account").as("account")
                                .push("account.roles").as("roles"),

                        project("_id","firstName","lastName","birthDate","gender","account.email","account.userName","account.functions")
                                .and(updated).as("age")
                                .and("roles").as("account.roles")
                                .and("account.email").as("account.email")
                                .and("account.userName").as("account.userName")
                                .and("account.functions").as("account.functions")
                ).toString()
        );
        return reactiveMongoOperations.aggregate(
                Aggregation.newAggregation(
                Aggregation.match(Criteria.where("_id").is(new ObjectId(id))),
                unwind("account.roles"),
                lookup("role","account.roles","_id","account.roles"),
                unwind("account.roles"),
                group( "_id")
                        .first("firstName").as("firstName")
                        .first("lastName").as("lastName")
                        .first("birthDate").as("birthDate")
                        .first("gender").as("gender")
                        .first("account").as("account")
                        .push("account.roles").as("roles"),

                project("_id","firstName","lastName","birthDate","gender","account.email","account.userName","account.functions")
                        .and(updated).as("age")
                        .and("roles").as("account.roles")
                        .and("account.email").as("account.email")
                        .and("account.userName").as("account.userName")
                        .and("account.functions").as("account.functions")
        ),"user",UserWithoutPasswordDto.class).map(e->e.setAge( floor((Double) e.getAge()))).publishNext();
    }

    @Override
    public Mono<User> getFullUser(String id) {
        return userDaoMongo.findById(id);
    }

}
