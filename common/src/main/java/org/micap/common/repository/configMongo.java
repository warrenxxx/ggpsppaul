/**
 * The configMongo class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :4/04/2018
 */
package org.micap.common.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;

public class configMongo {
    public static MongoClient MONGO_CLIENT = MongoClients.create();
    public static MongoDatabase DATABASE = MONGO_CLIENT.getDatabase("micapDev");
    public static ObjectMapper OBJECT_MAPPER=new ObjectMapper();
}
