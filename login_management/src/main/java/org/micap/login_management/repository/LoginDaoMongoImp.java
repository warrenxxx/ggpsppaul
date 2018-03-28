package org.micap.login_management.repository;

import org.bson.types.ObjectId;
import org.micap.common.config.AppError;
import org.micap.common.entity.User;
import org.micap.login_management.dto.FunctionsDto;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * The UserDaoImp class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@Service
public class LoginDaoMongoImp implements LoginDao {

    @Autowired
    LoginDaoMongo loginDaoMongo;

    @Autowired
    ReactiveMongoOperations reactiveMongoOperations;

    public Mono<String> getFunctions(String id) {
        return  reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                match(where("_id").is(new ObjectId(id))),
                replaceRoot("account"),
                unwind("roles"),
                lookup("role","roles","_id","roles"),
                unwind("roles"),
                unwind("roles.functions"),
                group().first("functions").as("functions").push("roles.functions").as("roles"),
                project().and("roles").concatArrays("functions").as("items"),
                unwind("items"),
                unwind("items.crudMethods"),
                project().andExpression("concat(items.entity,'-',items.crudMethods)").as("item"),
                group().push("item").as("functions")
        ),"user",FunctionsDto.class).publishNext().map(e-> Stream.of(e.getFunctions()).collect(Collectors.joining(",")));
    }

    @Override
    public Mono<User> getUser(String userName) {
        reactiveMongoOperations.aggregate(Aggregation.newAggregation(
            match(where("account.userName").is(userName))
        ),"user",User.class);
        return null;
    }

    @Override
    public Mono<UserDto> getUserDto(LoginDto loginDto) {
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(
                match(
                        where("account.userName")
                            .is(loginDto.getUserName())
                        .and("account.password")
                            .is(loginDto.getPassword())
                ),
                unwind("account.roles"),
                lookup("role","account.roles","_id","roles"),
                unwind("roles"),
                group("_id")
                        .first("firstName").as("firstName")
                        .first("lastName").as("lastName")
                        .first("birthDate").as("birthDate")
                        .first("gender").as("gender")
                        .first("account.email").as("email")
                        .first("account.userName").as("userName")
                        .first("functions").as("functions")
                        .push("roles").as("roles")

        ),"user",UserDto.class).publishNext();
    }


}
