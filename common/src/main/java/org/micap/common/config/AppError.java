package org.micap.common.config;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The AppError class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :18/03/2018
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AppError {

    public String errorCode;
    public String errorNameException;
    public String errorMessage;
    public String errorMessage2;
    public LocalDate errorDate;

    public Object data;
    public String paramKey;
    public String paramValue;


    public String operation;
    public String resource;

    /**
     * Sets the errorMessage2.
     *
     * @param errorMessage2 the errorMessage2 to set
     * @return AppError
     */
    public AppError setErrorMessage2(String errorMessage2) {
        this.errorMessage2 = errorMessage2;
        return this;
    }

    /**
     * Sets the errorCode.
     *
     * @param errorCode the errorCode to set
     * @return AppError
     */
    public AppError setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Sets the errorNameException.
     *
     * @param errorNameException the errorNameException to set
     * @return AppError
     */
    public AppError setErrorNameException(String errorNameException) {
        this.errorNameException = errorNameException;
        return this;
    }

    /**
     * Sets the errorMessage.
     *
     * @param errorMessage the errorMessage to set
     * @return AppError
     */
    public AppError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * Sets the errorDate.
     *
     * @param errorDate the errorDate to set
     * @return AppError
     */
    public AppError setErrorDate(LocalDate errorDate) {
        this.errorDate = errorDate;
        return this;
    }

    /**
     * Sets the data.
     *
     * @param data the data to set
     * @return AppError
     */
    public AppError setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * Sets the paramKey.
     *
     * @param paramKey the paramKey to set
     * @return AppError
     */
    public AppError setParamKey(String paramKey) {
        this.paramKey = paramKey;
        return this;
    }

    /**
     * Sets the paramValue.
     *
     * @param paramValue the paramValue to set
     * @return AppError
     */
    public AppError setParamValue(String paramValue) {
        this.paramValue = paramValue;
        return this;
    }

    /**
     * Sets the operation.
     *
     * @param operation the operation to set
     * @return AppError
     */
    public AppError setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Sets the resource.
     *
     * @param resource the resource to set
     * @return AppError
     */
    public AppError setResource(String resource) {
        this.resource = resource;
        return this;
    }
}
