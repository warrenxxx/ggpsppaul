package org.micap.common.ExceptionHandling;


import org.micap.common.config.AppError;

/**
 * The AuthorizationException class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :23/03/2018
 */
public class UserWithouhtFunctionsException extends BaseException {
    public UserWithouhtFunctionsException(String userName) {
        super(
                new AppError()
                        .setParamKey("userName")
                        .setParamValue(userName)
                        .setErrorNameException(UserWithouhtFunctionsException.class.getSimpleName() )
        );
    }
}
