package org.micap.common.config;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

/**
 * The AppError class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@AllArgsConstructor
public class AppError {

    public final String errorCode;
    public final String errorMessage;

    public final LocalDate errorDate;
    public final String userName;
    public final String operation;

    public final String resource;
    public final String ipAddress;
}
