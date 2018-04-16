package org.micap.login_management;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.async.client.MongoClientSettings;

import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;

import io.netty.channel.nio.NioEventLoopGroup;
import org.micap.common.config.CorsConfiguration;

import org.micap.common.entity.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.server.WebFilter;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static java.util.Arrays.asList;


@SpringBootApplication
public class LoginManagementApplication {


    public static void main(final String[] args) {
        SpringApplication.run(LoginManagementApplication.class, args);
    }
    @Bean
    public WebFilter corsFilter() {
        return CorsConfiguration.corsFilter();
    }
    private NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    @Autowired
    Environment environment;
    @Bean
    CommandLineRunner commandLineRunner(){
        return  args -> {

        };
    }
    private MongoClient createMongoClient(String uri) {
        return new MongoClient(new MongoClientURI(uri));
    }


}
