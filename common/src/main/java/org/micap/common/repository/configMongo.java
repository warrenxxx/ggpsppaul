/**
 * The configMongo class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :4/04/2018
 */
package org.micap.common.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.bson.Document;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

public class configMongo {
    public static MongoClient MONGO_CLIENT_MICAP=MongoClients.create("mongodb://hammer:micap123@cluster0-shard-00-00-x5n39.mongodb.net:27017,cluster0-shard-00-01-x5n39.mongodb.net:27017,cluster0-shard-00-02-x5n39.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
    public static ReactiveMongoOperations MONGO_OPS_MICAP = new ReactiveMongoTemplate(MONGO_CLIENT_MICAP, "micapDev");
}
