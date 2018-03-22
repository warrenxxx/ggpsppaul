package org.micap.user_manage.repository;

import org.bson.types.ObjectId;
import org.micap.common.entity.Account;
import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_manage.dto.AccountDto;
import org.micap.user_manage.dto.UserDto;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.replaceRoot;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

/**
 * The UserDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :19/03/2018
 */
public interface UserDao {
    public Flux<UserDto> getUsers();
    public Mono<UserDto> getUser(String id);
    public Flux<AccountDto> getUsersbyUsernameAndEmail(String userName, String email);
    public Mono<User> getUser(String username, String password);
    public Flux<Function> getFunctions(String id);

    public Mono<UserDto> createUser(User user);
    public Mono<UserDto> updateUser(User user);

    public Mono<Void> deleteUser(User user);
    public Mono<Void> deleteUser(String id);
}
