package org.micap.common.ExceptionHandling;

import org.micap.common.CommonApplication;
import org.micap.common.config.AppError;
import org.micap.common.utilies.AppProperties;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;

import java.sql.SQLOutput;
import java.time.LocalDate;

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

        CommonApplication.ERROR_DAO.saveError(appError);
    }
    public BaseException(AppError appError,Object object) {
        super(getErrorMessage(appError));
        appError.setData(object);
        this.appError=appError;

        CommonApplication.ERROR_DAO.saveError(appError);
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

