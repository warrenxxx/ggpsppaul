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

public class BaseException extends Exception{


    private AppError appError;

    public BaseException(AppError appError) {
        super(getErrorMessage(appError));
        saveDataBase(appError);
    }
    public BaseException(AppError appError,Object object) {
        super(getErrorMessage(appError));
        saveDataBase(appError);
    }

    private static String getErrorMessage(AppError appError){
        String properti= AppProperties.readProperties(appError.errorNameException);
        String []propertiesValue=properti.split("|");
        String message="Error: "+appError.errorNameException+" - Code: "+propertiesValue[1]+" - Message:" +propertiesValue[2] ;

        message=String.format(message,new String[]{appError.paramKey,appError.paramValue});
        appError.errorMessage=message;
        return message;
    }
    private static void saveDataBase(AppError appError){
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost"));
        MongoDatabase database = mongoClient.getDatabase("error");
        MongoCollection<Document> collection = database.getCollection("restaurants");

        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = oMapper.convertValue(appError, Map.class);

        Document document = new Document(map) ;


        collection.insertOne(document,(r,t)->{

            System.out.println("insertado el errro");
        });
    }
}

