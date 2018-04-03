package org.micap.user_management.repository;

import org.micap.common.entity.Function;
import org.micap.common.entity.User;
import org.micap.user_management.dto.AccountDto;
import org.micap.user_management.dto.UserDto;
import org.micap.user_management.dto.UserWithoutPasswordDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The UserDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :19/03/2018
 */
public interface UserDao {
    public Flux<UserDto> getUsers();
    public Mono<UserWithoutPasswordDto> getUser(String id);
    public Flux<AccountDto> getUsersbyUsername(String userName);
    public Mono<User> getUser(String username, String password);
    public Flux<Function> getFunctions(String id);

    public Mono<UserDto> createUser(User user);
    public Mono<UserDto> updateUser(User user);

    public Mono<Void> deleteUser(User user);
    public Mono<Void> deleteUser(String id);
    public Mono<Boolean> existById(String id);
}
