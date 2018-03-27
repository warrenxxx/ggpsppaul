package org.micap.login_management.repository;

import org.micap.common.entity.User;
import org.micap.login_manage.dto.LoginDto;
import org.micap.login_manage.dto.UserDto;
import reactor.core.publisher.Mono;

/**
 * The LoginDao class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :19/03/2018
 */
public interface LoginDao {
    public Mono<String> getFunctions(String id);
    public Mono<User> getUser(String userName);
    public Mono<UserDto> getUserDto(LoginDto loginDto);

}
