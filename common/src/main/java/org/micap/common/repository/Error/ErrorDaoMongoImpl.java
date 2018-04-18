package org.micap.common.repository.Error;


import com.mongodb.ConnectionString;
import com.mongodb.Mongo;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import io.netty.channel.nio.NioEventLoopGroup;
import org.micap.common.config.AppError;
import org.micap.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import static java.util.Arrays.asList;


/**
 * The ErrorDaoMongoImpl class is implemment to
 *
 * @version :1.0
 * @Author :warren
 * @since :22/03/2018
 */
public class ErrorDaoMongoImpl implements ErrorDao{

    @Autowired
    public static Environment environment;

    public final MongoClient MONGO_CLIENT;

    public ErrorDaoMongoImpl() {
        MongoProperties mongoProperties=new MongoProperties();
        mongoProperties.setUri("mongodb://hammer:micap123@cluster0-shard-00-00-x5n39.mongodb.net:27017,cluster0-shard-00-01-x5n39.mongodb.net:27017,cluster0-shard-00-02-x5n39.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

        ReactiveMongoClientFactory RF=new ReactiveMongoClientFactory(mongoProperties,environment,asList());
        MongoClientSettings ms=                MongoClientSettings.builder()
                .sslSettings(SslSettings.builder()
                        .applyConnectionString(new ConnectionString("mongodb+srv://hammer:micap123@cluster0-x5n39.mongodb.net/test&ssl=true"))
                        .enabled(true)
                        .build())
                .streamFactoryFactory(NettyStreamFactoryFactory.builder()
                        .eventLoopGroup(eventLoopGroup).build())
                .build();
        this.MONGO_CLIENT=RF.createMongoClient(ms);
    }

    public void saveError(AppError appError) {

        ReactiveMongoOperations OPS=new ReactiveMongoTemplate(MONGO_CLIENT,"test2");
        OPS.insert(appError).subscribe(System.out::print);


    }


    private static NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    public MongoClientSettingsBuilderCustomizer sslCustomizer() {
        return clientSettingsBuilder -> clientSettingsBuilder
                .sslSettings(SslSettings.builder()
                        .enabled(true)
                        .invalidHostNameAllowed(true)
                        .build())
                .streamFactoryFactory(NettyStreamFactoryFactory.builder()
                        .eventLoopGroup(eventLoopGroup).build());
    }

    public static void main(String args[]){
        MongoProperties mongoProperties=new MongoProperties();

        mongoProperties.setUri("mongodb://hammer:micap123@cluster0-shard-00-00-x5n39.mongodb.net:27017,cluster0-shard-00-01-x5n39.mongodb.net:27017,cluster0-shard-00-02-x5n39.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
        ReactiveMongoClientFactory RF=new ReactiveMongoClientFactory(mongoProperties,environment,asList());
        MongoClientSettings ms=                MongoClientSettings.builder()
                .sslSettings(SslSettings.builder()
                        .applyConnectionString(new ConnectionString("mongodb+srv://hammer:micap123@cluster0-x5n39.mongodb.net/test&ssl=true"))
                        .enabled(true)
                        .build())
                .streamFactoryFactory(NettyStreamFactoryFactory.builder()
                        .eventLoopGroup(eventLoopGroup).build())
                .build();

        ReactiveMongoOperations OPS=new ReactiveMongoTemplate(RF.createMongoClient(ms),"test2");
        OPS.getCollectionNames().subscribe(System.out::print);
    }
}
