package org.micap.login_manage.repository;

import org.bson.types.ObjectId;
import org.micap.common.entity.User;
import org.micap.login_manage.dto.FunctionsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

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
                match(Criteria.where("_id").is(new ObjectId(id))),
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
            match(Criteria.where("account.userName").is(userName))
        ),"user",User.class);
        return null;
    }
}
