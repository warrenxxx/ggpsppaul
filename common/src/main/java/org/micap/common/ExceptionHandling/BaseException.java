package org.micap.common.ExceptionHandling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import org.micap.common.config.AppError;
import org.micap.common.repository.ErrorDaoMongoImpl;
import org.micap.common.utilies.AppProperties;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

/**
 * The BaseException class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :20/03/2018
 */

public class BaseException extends Throwable{
    public AppError appError;

    public BaseException(AppError appError) {
        super(getErrorMessage(appError));
        this.appError=appError;
        ErrorDaoMongoImpl.saveError(appError);
    }
    public BaseException(AppError appError,Object object) {
        super(getErrorMessage(appError));
        appError.setData(object);
        this.appError=appError;

        ErrorDaoMongoImpl.saveError(appError);
    }
    private static String getErrorMessage(AppError appError){

        String properti= AppProperties.readProperties(appError.errorNameException);
        String []propertiesValue=properti.split("--");

        appError.setErrorCode(propertiesValue[0]);

        String message="Error: "+appError.errorNameException+" - Code: "+propertiesValue[0]+" - Message:" +propertiesValue[2] ;
        message=String.format(message,new String[]{appError.paramKey,appError.paramValue});
//        appError.errorMessageControlado=message;
        appError.setErrorMessageControlado(message)
                .setErrorDate(LocalDate.now());
        return message;
    }
}

