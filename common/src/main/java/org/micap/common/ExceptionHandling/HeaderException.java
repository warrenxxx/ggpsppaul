package org.micap.common.ExceptionHandling;

import org.micap.common.config.AppError;

/**
 * The HeaderException class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :24/03/2018
 */
public class HeaderException extends BaseException{

        public HeaderException(String header) {
            super(
                    new AppError()
                    .setParamKey("Header")
                    .setParamValue(header)
                    .setErrorNameException(HeaderException.class.getSimpleName())
            );
        }
}
