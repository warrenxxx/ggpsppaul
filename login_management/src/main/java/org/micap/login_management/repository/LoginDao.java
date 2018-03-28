package org.micap.login_management.repository;

import org.micap.common.entity.User;
import org.micap.login_management.dto.LoginDto;
import org.micap.login_management.dto.UserDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
