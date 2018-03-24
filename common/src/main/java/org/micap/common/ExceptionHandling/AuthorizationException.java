package org.micap.common.ExceptionHandling;

import org.micap.common.config.AppError;

/**
 * The AuthorizationException class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :23/03/2018
 */
public class AuthorizationException extends BaseException {

    public AuthorizationException(AppError appError) {
        super(appError);
    }
}
