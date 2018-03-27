package org.micap.common.ExceptionHandling;

import org.micap.common.config.AppError;

public class DuplicateUserNameException extends BaseException {

    public DuplicateUserNameException(String userName) {
        super(
                new AppError().setErrorNameException(DuplicateUserNameException.class.getSimpleName())
                .setParamKey("userName")
                .setParamValue(userName)

        );
    }
}
