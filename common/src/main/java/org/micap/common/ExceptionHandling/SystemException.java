package org.micap.common.ExceptionHandling;

import org.micap.common.config.AppError;

/**
 * The SystemException class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :24/03/2018
 */
public class SystemException extends  BaseException{
    public SystemException(String key,String value,String message) {
        super(
                new AppError()
                        .setParamKey(key)
                        .setParamValue(value)
                .setErrorNameException(SystemException.class.getSimpleName())
                .setErrorMessage2(message)
        );
    }
    public SystemException(Throwable t) {
        super(
                new AppError()
                        .setParamKey(t.getClass().getSimpleName())
                        .setParamValue(t.getLocalizedMessage())
                        .setErrorNameException(SystemException.class.getSimpleName())
                        .setErrorMessage2(t.getMessage())
        );
    }
}
