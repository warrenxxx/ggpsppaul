package org.micap.common.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import org.micap.common.config.AppError;

import java.util.Map;

/**
 * The ErrorDaoMongoImpl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :22/03/2018
 */
public class ErrorDaoMongoImpl{

    private static MongoClient mongoClient = MongoClients.create();
    private static MongoDatabase database = mongoClient.getDatabase("devMicap");
    private static MongoCollection<Document> collection = database.getCollection("errors");
    private static ObjectMapper objectMapper=new ObjectMapper();

    public static void saveError(AppError appError) {
        Document document = new Document(objectMapper.convertValue(appError,Map.class)) ;
        collection.insertOne(document,(Void r,final Throwable t)->
                System.out.println("error Inserted!!!")
        );
    }
}
