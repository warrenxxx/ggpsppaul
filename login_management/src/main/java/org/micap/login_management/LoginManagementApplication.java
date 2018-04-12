package org.micap.login_management;


import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.mongodb.session.ClientSession;
import org.micap.common.config.CorsConfiguration;
import org.micap.common.entity.User;
import org.micap.login_management.repository.LoginDaoMongo;
import org.micap.login_management.repository.LoginDaoMongoImp;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.server.WebFilter;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class LoginManagementApplication {


    public static void main(final String[] args) {
        SpringApplication.run(LoginManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            ReactiveMongoOperations mongoOps = new ReactiveMongoTemplate(MongoClients.create("mongodb://localhost"), "REACTIVE1");
            mongoOps.insert(new Person("Joe1", 34)).subscribe(System.out::print);

            ReactiveMongoOperations mongoOps2 = new ReactiveMongoTemplate(MongoClients.create("mongodb://localhost"), "REACTIVE2");
            mongoOps2.insert(new Person("JoeS1", 344)).subscribe(System.out::print);



        };

    }
}

class Person {

    private String id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}