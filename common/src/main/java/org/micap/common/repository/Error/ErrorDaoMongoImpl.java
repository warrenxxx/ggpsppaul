package org.micap.common.repository.Error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import org.micap.common.config.AppError;

import java.util.Map;

import static org.micap.common.repository.configMongo.DATABASE;
import static org.micap.common.repository.configMongo.OBJECT_MAPPER;

/**
 * The ErrorDaoMongoImpl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :22/03/2018
 */
public class ErrorDaoMongoImpl implements ErrorDao{
    public static MongoCollection<Document> COLLECTION_ERROR = DATABASE.getCollection("errors");

    public void saveError(AppError appError) {
        Document document = new Document(OBJECT_MAPPER.convertValue(appError,Map.class)) ;
        COLLECTION_ERROR.insertOne(document,(Void r,final Throwable t)->
                System.out.println("error Inserted!!!")
        );
    }


}
