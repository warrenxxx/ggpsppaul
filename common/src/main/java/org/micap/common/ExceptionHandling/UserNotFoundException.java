package org.micap.common.ExceptionHandling;

import org.micap.common.config.AppError;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

/**
 * The UserNotFountExecptions class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String key,String value) {
        super(
                new AppError()
                .setErrorNameException(UserNotFoundException.class.getSimpleName())
                .setParamKey(key)
                .setParamValue(value)
        );
    }
    public UserNotFoundException() {
        super(
                new AppError()
                        .setErrorNameException(UserNotFoundException.class.getSimpleName())
                        .setParamKey(" ")
                        .setParamValue(" ")
        );
    }

}